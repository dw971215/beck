package com.beck.weixin.constant;

/**
 * 微信开放api鉴权常量
 * @Author dawei
 * @Date 2021/9/9 22:04
 */
public class WXApiAuthConstant {

    /**
     * 微信本地开放接口 鉴权token 前缀
     */
    public final static String API_TOKEN_KEY = "weixin:api:token:";

    /**
     * 微信请求接口有效期
     */
    public final static long TOKEN_EXPIRE_TIME = 60 * 60 * 24 * 1000;
}
