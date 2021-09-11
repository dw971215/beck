package com.beck.weixin.constant;

import org.springframework.stereotype.Component;

/**
 * 微信redis各种类型键值配置
 * @Author dawei
 * @Date 2021/9/2 17:44
 */
@Component
public class WXRedisConstant {

    /**
     * 微信基础服务请求令牌的键值
     */
    public final static String ACCESS_TOKEN_KEY = "weixin:access_token:";

    /**
     * 微信基础服务请求令牌的键值过期时间(单位：分钟)
     */
    public final static Integer ACCESS_TOKEN_EXPIRE = 100;
}
