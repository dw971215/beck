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
    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token";

    /**
     * 微信二维码生成地址
     */
    public final static String create_qrcode_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";

    /**
     * 显示微信二维码地址
     */
    public final static String show_qrcode_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode";

    /**
     * 微信网页授权获取的access_token地址
     */
    public final static String web_access_token_url = " https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * 微信网页授权拉取用户信息地址
     */
    public final static String web_getUserInfo_url = "https://api.weixin.qq.com/sns/userinfo";
}
