package com.beck.weixin.login;

import com.alibaba.fastjson.JSONObject;
import com.beck.address.domain.BeckCustomerAddress;
import com.beck.address.service.IBeckCustomerAddressService;
import com.beck.assets.domain.BeckCustomerAssets;
import com.beck.assets.service.IBeckCustomerAssetsService;
import com.beck.common.core.domain.AjaxResult;
import com.beck.common.utils.StringUtils;
import com.beck.common.utils.sign.Md5Utils;
import com.beck.common.utils.uuid.UUID;
import com.beck.customer.domain.BeckCustomer;
import com.beck.customer.service.IBeckCustomerService;
import com.beck.weixin.core.WeiXinBaseApi;
import com.beck.weixin.core.auth.OauthApi;
import com.beck.weixin.utils.WXUtlis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 微信自动授权获取用户信息接口
 * @Author dawei
 * @Date 2021/9/22 11:31
 */
@Api
@RestController
public class WXAutoLoginApi extends WeiXinBaseApi {

    @Autowired
    private IBeckCustomerService customerService;

    @Autowired
    private IBeckCustomerAssetsService beckCustomerAssetsService;

    @Autowired
    private IBeckCustomerAddressService beckCustomerAddressService;
    /**
     * H5网页授权登录
     * @param code
     * @return
     */
    @GetMapping(value = "/wxH5AutoLogin")
    public AjaxResult index(@ApiParam(name = "code",value = "code",required = true) String code){
        String userInfo = OauthApi.getUserInfo(weiXinConfig.getTestAppID(), weiXinConfig.getTestAppSecret(), code);
        Object parse = JSONObject.parse(userInfo);
        return AjaxResult.success(parse);
    }

    /**
     * 微信小程序授权登录获取用户信息
     * @param code
     * @return
     */
    @GetMapping(value = "/wxAppAutoLogin")
    public AjaxResult wxAppletAutoLogin(@ApiParam(name = "code",value = "临时授权code",required = true) String code,
                                        @ApiParam(name = "iv",value = "加密算法的初始向量",required = true) String iv,
                                        @ApiParam(name = "encryptedData",value = "包括敏感数据在内的完整用户信息的加密数据",required = true) String encryptedData){
        JSONObject sessionKeyOrOpenId = OauthApi.getSessionKeyOrOpenId(weiXinConfig.getWxAppletAppId(), weiXinConfig.getWxAppletAppSecret(), code);
        String openid = sessionKeyOrOpenId.getString("openid");
        if(StringUtils.isBlank(openid)){
            return AjaxResult.error("获取用户信息失败");
        }
        BeckCustomer res = new BeckCustomer();
        try {
            JSONObject  userInfo = WXUtlis.dencryptedUserData(encryptedData, sessionKeyOrOpenId.getString("session_key"), iv);
            //查询是否存在用户
            BeckCustomer beckCustomer = customerService.selectBeckCustomerByOpenId(openid);
            if(beckCustomer == null){
                //没有该用户信息 创建一个用户
                BeckCustomer insertCustom = new BeckCustomer();
                insertCustom.setId(UUID.randomUUID().toString());
                insertCustom.setDelFlag("0");
                //头像地址
                insertCustom.setLoginPhoto(userInfo.getString("avatarUrl"));
                insertCustom.setLoginPassword(Md5Utils.hash("111111"));
                insertCustom.setNickName(userInfo.getString("nickName"));
                insertCustom.setGender(userInfo.getString("gender"));
                insertCustom.setWxOpenid(openid);
                insertCustom.setCustomerSource("1");
                customerService.insertBeckCustomer(insertCustom);
                //创建完成后给用户插入一条资产记录
                BeckCustomerAssets beckCustomerAssets = new BeckCustomerAssets();
                beckCustomerAssets.setId(UUID.randomUUID().toString());
                beckCustomerAssets.setBalance(BigDecimal.ZERO);
                beckCustomerAssets.setCurrentValue(100L);
                beckCustomerAssets.setMemberLevel(1);
                beckCustomerAssets.setPointNum(10L);
                beckCustomerAssets.setUser(new BeckCustomer(insertCustom.getId()));
                beckCustomerAssetsService.insertBeckCustomerAssets(beckCustomerAssets);
                insertCustom.setBeckCustomerAssets(beckCustomerAssets);
                res = insertCustom;
            }else{
                beckCustomer.setNickName(userInfo.getString("nickName"));
                beckCustomer.setLoginPhoto(userInfo.getString("avatarUrl"));
                customerService.updateBeckCustomer(beckCustomer);
                //获取用户地址
                BeckCustomerAddress beckCustomerAddress = new BeckCustomerAddress();
                beckCustomerAddress.setUser(new BeckCustomer(beckCustomer.getId()));
                List<BeckCustomerAddress> beckCustomerAddresses = new ArrayList<>();
                beckCustomerAddresses = beckCustomerAddressService.selectBeckCustomerAddressList(beckCustomerAddress);
                beckCustomer.setBeckCustomerAddresses(beckCustomerAddresses);
                res = beckCustomer;
            }
            logger.info("userInfo message:"+userInfo.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("登录失败");
        }

        return AjaxResult.success(res);
    }

}
