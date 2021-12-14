package com.beck.weixin.core.auth;

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
 * 微信授权获取工具
 * @Author dawei
 * @Date 2021/9/2 17:39
 */
@Component
public class OauthApi extends WXBaseCore {

   private static Logger logger = LoggerFactory.getLogger(OauthApi.class);

    /**
     * 获取微信请求Token
     * @param appId
     * @param appSecret
     * @return
     */
    public static synchronized String getAccessToken(String appId, String appSecret) {

        if (redisCache.hasKey(WXRedisConstant.ACCESS_TOKEN_KEY + appId)) {
            return redisCache.getCacheObject(WXRedisConstant.ACCESS_TOKEN_KEY + appId);
        }
        StringBuilder params = new StringBuilder();
        params.append("grant_type=client_credential");
        params.append("&appid=" + appId);
        params.append("&secret=" + appSecret);
        String result = HttpUtils.sendGet(WXApiUrlConstant.ACCESS_TOKEN_URL, params.toString());
        JSONObject TokenResult = JSONObject.parseObject(result);
        String access_token = TokenResult.getString("access_token");
        if (StringUtils.isNotBlank(access_token)) {
            logger.info("获取access_token成功");
            redisCache.setCacheObject(WXRedisConstant.ACCESS_TOKEN_KEY + appId, access_token,
                    WXRedisConstant.ACCESS_TOKEN_EXPIRE, TimeUnit.MINUTES);
            return TokenResult.getString("access_token");
        }
        String errMsg = WXErrCode.WXErrMsg(TokenResult);
        logger.info(errMsg);
        return errMsg;
    }

    /**
     * 获取网页授权请求信息
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
        String result = HttpUtils.sendGet(WXApiUrlConstant.WEB_ACCESS_TOKEN_URL, params.toString());
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
        String result = HttpUtils.sendGet(WXApiUrlConstant.WEB_GETUSERINFO_URL, params.toString());
        JSONObject resultJson = JSONObject.parseObject(result);
        String nickname = resultJson.getString("nickname");
        if (StringUtils.isNotBlank(nickname)) {
            return result;
        }
        String errMsg = WXErrCode.WXErrMsg(resultJson);
        logger.info(errMsg);
        return errMsg;
    }

    /**
     * 获取小程序授权key 和openid
     * GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
     * @param appId
     * @param appSecret
     * @param code
     * @return
     */
    public static synchronized JSONObject getSessionKeyOrOpenId(String appId, String appSecret,String code) {
        StringBuilder params = new StringBuilder();
        params.append("appid=" + appId);
        params.append("&secret=" + appSecret);
        params.append("&js_code=" + code);
        params.append("&grant_type=authorization_code");
        String result = HttpUtils.sendGet(WXApiUrlConstant.APP_GETUSERINFO_URL, params.toString());
        JSONObject resultJson = JSONObject.parseObject(result);
        String openid = resultJson.getString("openid");
        if (StringUtils.isNotBlank(openid)) {
            return resultJson;
        }
        String errMsg = WXErrCode.WXErrMsg(resultJson);
        logger.info(errMsg);
        return new JSONObject();
    }

}
