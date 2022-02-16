package com.beck.weixin.config;

import com.beck.common.utils.yml.YamlPropertySourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 默认加载的Properties配置文件不支持yml
 * 微信所有属性配置类
 * @Author dawei
 * @Date 2021/9/2 11:08
 */
@Component
@PropertySource(value = { "classpath:weixin-config.yml" },
        factory = YamlPropertySourceFactory.class)
public class WeiXinConfig {

    /**
     * 微信公众号appid
     */
    @Value("${weixin.AppID}")
    private String AppID;

    @Value("${weixin.AppSecret}")
    private String AppSecret;

    @Value("${weixin.TestAppId}")
    private String testAppID;

    @Value("${weixin.TestAppSecret}")
    private String testAppSecret;

    @Value("${valit.url}")
    private String valitUrl;

    @Value("${valit.token}")
    private String valitToken;

    //微信小程序
    @Value("${wxApplet.AppId}")
    private String WxAppletAppId;

    @Value("${wxApplet.AppSecret}")
    private String WxAppletAppSecret;

    @Value("${wxApplet.farmAppId}")
    private String WxFarmAppletAppId;

    @Value("${wxApplet.farmAppSecret}")
    private String WxFarmAppletAppSecret;

    public String getAppID() {
        return AppID;
    }

    public String getAppSecret() {
        return AppSecret;
    }

    public String getTestAppID() {
        return testAppID;
    }

    public String getTestAppSecret() {
        return testAppSecret;
    }

    public String getValitUrl() {
        return valitUrl;
    }

    public String getValitToken() {
        return valitToken;
    }

    public String getWxAppletAppId() {
        return WxAppletAppId;
    }

    public String getWxAppletAppSecret() {
        return WxAppletAppSecret;
    }

    public String getWxFarmAppletAppId() {
        return WxFarmAppletAppId;
    }

    public String getWxFarmAppletAppSecret() {
        return WxFarmAppletAppSecret;
    }
}
