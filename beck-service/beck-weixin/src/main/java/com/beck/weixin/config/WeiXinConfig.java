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

    @Value("${test.AppID}")
    private String testAppID;

    @Value("${test.AppSecret}")
    private String testAppSecret;

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

}
