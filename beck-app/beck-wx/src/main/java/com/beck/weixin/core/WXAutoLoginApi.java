package com.beck.weixin.core;

import com.alibaba.fastjson.JSONObject;
import com.beck.common.core.domain.AjaxResult;
import com.beck.weixin.core.webauth.WebOauthApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信自动登录接口
 * @Author dawei
 * @Date 2021/9/22 11:31
 */
@Api
@RestController
public class WXAutoLoginApi extends WeiXinBaseApi{

    @GetMapping(value = "/wxAutoLogin")
    public AjaxResult index(@ApiParam(name = "code",value = "code",required = true) String code){
        String userInfo = WebOauthApi.getUserInfo(weiXinConfig.getTestAppID(), weiXinConfig.getTestAppSecret(), code);
        Object parse = JSONObject.parse(userInfo);
        return AjaxResult.success(parse);
    }
}
