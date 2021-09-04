package com.beck.common.utils.yml;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;

import java.io.IOException;

/**
 * 读取yml配置文件的工厂
 * @Author dawei
 * @Date 2021/9/3 15:41
 */
@Configuration
public class YamlPropertySourceFactory implements PropertySourceFactory  {

    public YamlPropertySourceFactory() {
    }

    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        // 返回 yaml 属性资源
        return new YamlPropertySourceLoader ()
                .load (resource.getResource ().getFilename (), resource.getResource ())
                .get (0);
    }
}
