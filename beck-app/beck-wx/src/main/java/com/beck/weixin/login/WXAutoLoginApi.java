package com.beck.weixin.login;

import com.alibaba.fastjson.JSONObject;
import com.beck.common.core.domain.AjaxResult;
import com.beck.weixin.core.WeiXinBaseApi;
import com.beck.weixin.core.auth.OauthApi;
import com.beck.weixin.utils.WXUtlis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信自动授权获取用户信息接口
 * @Author dawei
 * @Date 2021/9/22 11:31
 */
@Api
@RestController
public class WXAutoLoginApi extends WeiXinBaseApi {

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
        JSONObject object = WXUtlis.dencryptedUserData(encryptedData, sessionKeyOrOpenId.getString("session_key"), iv);
        logger.info("userInfo message:"+object.toJSONString());
        return AjaxResult.success(object);
    }
}
