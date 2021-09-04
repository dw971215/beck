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
     * 微信请求获取token地址
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
}
