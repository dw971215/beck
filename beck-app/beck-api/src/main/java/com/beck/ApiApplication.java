package com.beck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ApiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ApiApplication.class, args);
        System.out.println(
                           "//////////////////////////////////////////////////////// \n"
                        + "//                                                    // \n"
                        + "//    (♥◠‿◠)ﾉﾞ  贝克-汉姆；API启动成功   ლ(´ڡ`ლ)ﾞ    // \n"
                        + "//                                                   // \n"
                        + "////////////////////////////////////////////////////// \n"
        );
    }
}

