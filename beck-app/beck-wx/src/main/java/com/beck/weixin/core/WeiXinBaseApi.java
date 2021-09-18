package com.beck.weixin.core;

import com.beck.common.core.redis.RedisCache;
import com.beck.common.utils.spring.SpringUtils;
import com.beck.weixin.config.WeiXinConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author dawei
 * @Date 2021/9/2 17:20
 */
@RequestMapping(value = "/weiXinServer")
public class WeiXinBaseApi {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 微信配置类
     */
    public WeiXinConfig weiXinConfig = SpringUtils.getBean(WeiXinConfig.class);

    /**
     * 缓存工具类
     */
    public RedisCache redisCache = SpringUtils.getBean(RedisCache.class);


}
