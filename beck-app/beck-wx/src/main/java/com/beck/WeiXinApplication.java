package com.beck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 */
@SpringBootApplication(scanBasePackages = {"com.beck"} , exclude = { DataSourceAutoConfiguration.class })
public class WeiXinApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(WeiXinApplication.class, args);
        System.out.println(
                           "//////////////////////////////////////////////////////// \n"
                        + "//                                                    // \n"
                        + "//    (♥◠‿◠)ﾉﾞ  贝克-汉姆；WeiXin启动成功   ლ(´ڡ`ლ)ﾞ // \n"
                        + "//                                                   // \n"
                        + "////////////////////////////////////////////////////// \n"
        );
    }
}

