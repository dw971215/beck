package com.beck.weixin.core;

import com.alibaba.fastjson.JSONObject;
import com.beck.common.core.domain.AjaxResult;
import com.beck.common.utils.StringUtils;
import com.beck.common.utils.uuid.IdUtils;
import com.beck.weixin.constant.WXApiAuthConstant;
import com.beck.weixin.constant.WXHttpStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 鉴权api
 * @Author dawei
 * @Date 2021/9/9 21:50
 */
@Api
@RestController
public class AuthTokenApi extends WeiXinBaseApi {


    @ApiOperation(value = "微信开放接口获取鉴权Token",
                  notes = "微信开放接口获取鉴权Token(只验证已过期的token,过期会返回一个新的token)",
                  httpMethod = "GET")
    @RequestMapping("/checkApiToken")
    public AjaxResult getApiToken(@ApiParam(name = "userId",value = "用户ID",required = true) String userId,
                                  HttpServletRequest request){

        if(StringUtils.isBlank(userId)){
            return AjaxResult.error("用户Id不能为空");
        }

        JSONObject res = redisCache.getCacheObject(WXApiAuthConstant.API_TOKEN_KEY + userId);
        if(res != null){
            //存在值 判断是否过期
            long expire_time = res.getLongValue("expire_time");
            if(System.currentTimeMillis() <= expire_time){
                //token没有过期
                return AjaxResult.success(res.get("api_token"));
            }
            //已过期
//            JSONObject tp = new JSONObject();
//            String tokenValue = IdUtils.fastUUID();
//            tp.put("api_token", tokenValue);
//            tp.put("expire_time", System.currentTimeMillis());
//            redisCache.setCacheObject(WXApiAuthConstant.API_TOKEN_KEY + userId,tp);
//            return AjaxResult.success(tokenValue);
             return AjaxResult.error(WXHttpStatus.RELOGIN,"授权已过期，请重新登录");
        }else{
            return AjaxResult.error(WXHttpStatus.NOTLOGIN,"未授权，请登录");
        }
    }


    @ApiOperation(value = "微信登录接口", notes = "微信登录接口", httpMethod = "GET")
    @RequestMapping("/login")
    public AjaxResult login() {
        String userId = "1111";
        JSONObject tp = new JSONObject();
        String tokenValue = IdUtils.fastUUID();
        tp.put("api_token", tokenValue);
        tp.put("expire_time", System.currentTimeMillis() + WXApiAuthConstant.TOKEN_EXPIRE_TIME);
        redisCache.setCacheObject(WXApiAuthConstant.API_TOKEN_KEY + userId, tp);
        JSONObject user = new JSONObject();
        user.put("id",userId);
        user.put("token",tokenValue);
        return AjaxResult.success(user);
    }
}
