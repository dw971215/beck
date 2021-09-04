package com.beck.weixin.core;

import com.beck.common.utils.spring.SpringUtils;
import com.beck.weixin.config.WeiXinConfig;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author dawei
 * @Date 2021/9/2 17:20
 */
@RequestMapping(value = "/weiXinServer")
public class WeiXinBaseController {

    /**
     * 微信配置类
     */
    public WeiXinConfig weiXinConfig = SpringUtils.getBean(WeiXinConfig.class);


}
