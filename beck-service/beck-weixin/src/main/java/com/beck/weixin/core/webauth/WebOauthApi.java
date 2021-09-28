package com.beck.weixin.core.webauth;

import com.alibaba.fastjson.JSONObject;
import com.beck.common.utils.StringUtils;
import com.beck.common.utils.http.HttpUtils;
import com.beck.weixin.constant.WXApiUrlConstant;
import com.beck.weixin.constant.WXRedisConstant;
import com.beck.weixin.core.WXBaseCore;
import com.beck.weixin.error.WXErrCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 微信网页授权获取Api
 * @Author dawei
 * @Date 2021/9/2 17:39
 */
@Component
public class WebOauthApi extends WXBaseCore {

   private static Logger logger = LoggerFactory.getLogger(WebOauthApi.class);

    /**
     * 获取网页授权请求信息token
     * @param appId
     * @param appSecret
     * @param code 请求凭证
     * @return
     */
    public static synchronized String getUserInfo(String appId, String appSecret, String code) {
        if (redisCache.hasKey(WXRedisConstant.WEB_ACCESS_TOKEN_KEY + appId)) {
            Object cacheObject = redisCache.getCacheObject(WXRedisConstant.WEB_ACCESS_TOKEN_KEY + appId);
            JSONObject parse = JSONObject.parseObject(cacheObject.toString());
            //TODO 刷新access_token 待开发 目前的access_token只支持2个小时
            String userInfo = getUserInfo(parse.getString("access_token"), parse.getString("openid"));
            return userInfo;
        }
        StringBuilder params = new StringBuilder();
        params.append("appid=" + appId);
        params.append("&secret=" + appSecret);
        params.append("&code=" + code);
        params.append("&grant_type=authorization_code");
        String result = HttpUtils.sendGet(WXApiUrlConstant.web_access_token_url, params.toString());
        JSONObject TokenResult = JSONObject.parseObject(result);
        String access_token = TokenResult.getString("access_token");
        if (StringUtils.isNotBlank(access_token)) {
            redisCache.setCacheObject(WXRedisConstant.WEB_ACCESS_TOKEN_KEY + appId, result,
                    WXRedisConstant.WEB_ACCESS_TOKEN_EXPIRE, TimeUnit.MINUTES);
            String userInfo = getUserInfo(access_token, TokenResult.getString("openid"));
            return userInfo;
        }
        String errMsg = WXErrCode.WXErrMsg(TokenResult);
        logger.info(errMsg);
        return errMsg;
    }
    /**
     * 获取网页授权用户基本信息
     * @param access_token
     * @param openid
     * @return
     */
    public static synchronized String getUserInfo(String access_token, String openid) {
        StringBuilder params = new StringBuilder();
        params.append("access_token=" + access_token);
        params.append("&openid=" + openid);
        params.append("&lang=zh_CN");
        String result = HttpUtils.sendGet(WXApiUrlConstant.web_getUserInfo_url, params.toString());
        JSONObject resultJson = JSONObject.parseObject(result);
        String nickname = resultJson.getString("nickname");
        if (StringUtils.isNotBlank(nickname)) {
            return result;
        }
        String errMsg = WXErrCode.WXErrMsg(resultJson);
        logger.info(errMsg);
        return errMsg;
    }

}
