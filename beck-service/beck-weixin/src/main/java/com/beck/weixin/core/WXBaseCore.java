package com.beck.weixin.core;

import com.beck.common.core.redis.RedisCache;
import com.beck.common.utils.spring.SpringUtils;

/**
 * 通用的类 属性 集中地
 * @Author dawei
 * @Date 2021/9/3 16:14
 */

public class WXBaseCore {
    /**
     * 获取redis缓存
     */
    public static RedisCache redisCache = SpringUtils.getBean(RedisCache.class);
}
