package com.beck.dingTalk.utils;

import com.beck.common.core.redis.RedisCache;
import com.beck.common.utils.StringUtils;
import com.beck.common.utils.spring.SpringUtils;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiV2UserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiV2UserGetuserinfoResponse;
import com.taobao.api.ApiException;

import java.util.concurrent.TimeUnit;

public class DingTalkOauthUtil {


    private static RedisCache redisCache = SpringUtils.getBean(RedisCache.class);
    /**
     * 获取钉钉免密token
     * @return
     */
    public static String getToken(String appKey,String appSecret){
        try {
            if(redisCache.getCacheObject("ding:talk:token:"+appKey) != null){
               return redisCache.getCacheObject("ding:talk:token:"+appKey);
            }else{
                DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
                OapiGettokenRequest request = new OapiGettokenRequest();
                request.setAppkey(appKey);
                request.setAppsecret(appSecret);
                request.setHttpMethod("GET");
                OapiGettokenResponse response = client.execute(request);
                redisCache.setCacheObject("ding:talk:token:"+appKey,response.getAccessToken(),90 * 60, TimeUnit.SECONDS);
                System.out.println(response.getBody());
                return response.getAccessToken();
            }
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 根据免登录码获取
     * @param code
     * @param access_token
     * @return
     */
    public static OapiV2UserGetuserinfoResponse.UserGetByCodeResponse getUserInfo(String code, String access_token){
        if(StringUtils.isBlank(code) || StringUtils.isBlank(access_token)){
            return null;
        }
        try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/getuserinfo");
            OapiV2UserGetuserinfoRequest req = new OapiV2UserGetuserinfoRequest();
            req.setCode(code);
            OapiV2UserGetuserinfoResponse rsp = client.execute(req, access_token);
            OapiV2UserGetuserinfoResponse.UserGetByCodeResponse result = rsp.getResult();
            System.out.println(rsp.getBody());
            return result;
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }


}
