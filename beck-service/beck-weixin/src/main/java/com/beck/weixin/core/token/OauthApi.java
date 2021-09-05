package com.beck.weixin.core.token;

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
 * 微信授权Api
 * @Author dawei
 * @Date 2021/9/2 17:39
 */
@Component
public class OauthApi  extends WXBaseCore {

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
        String result = HttpUtils.sendGet(WXApiUrlConstant.access_token_url, params.toString());
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


}
