package com.beck.dingTalk.core;

import com.beck.common.core.redis.RedisCache;
import com.beck.common.utils.spring.SpringUtils;

/**
 * 钉钉模块所有基本工具
 * @Author dawei
 * @Date 2021/9/3 16:14
 */

public class DingTalkCore {
    /**
     * 获取redis缓存
     */
    public static RedisCache redisCache = SpringUtils.getBean(RedisCache.class);
}
