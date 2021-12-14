package com.beck.weixin.constant;

import org.springframework.stereotype.Component;

/**
 * 微信各种请求api地址
 * @Author dawei
 * @Date 2021/9/2 17:50
 */
@Component
public class WXApiUrlConstant {


    /**
     * 微信请求获取基本token地址
     */
    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    /**
     * 微信二维码生成地址
     */
    public final static String CREATE_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";

    /**
     * 显示微信二维码地址
     */
    public final static String SHOW_QRCODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode";

    /**
     * 微信网页授权获取的access_token地址
     */
    public final static String WEB_ACCESS_TOKEN_URL = " https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * 微信网页授权拉取用户信息地址
     */
    public final static String WEB_GETUSERINFO_URL = "https://api.weixin.qq.com/sns/userinfo";

    /**
     * 微信小程序获取授权用户信息
     */
    public final static String APP_GETUSERINFO_URL = "https://api.weixin.qq.com/sns/jscode2session";
}
