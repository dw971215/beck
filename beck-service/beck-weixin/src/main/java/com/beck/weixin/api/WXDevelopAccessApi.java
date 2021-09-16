package com.beck.weixin.api;


import com.beck.common.utils.ServletUtils;
import com.beck.weixin.core.ApiServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证微信消息真实性api
 * 开发者接入
 * @Author dawei
 * @Date 2021/9/5 14:07
 */
@RestController
@RequestMapping("/weiXinServer/developAccess")
public class WXDevelopAccessApi extends ApiServlet {

    private static Logger logger = LoggerFactory.getLogger(WXDevelopAccessApi.class);

    /**
     * 开发者接入
     * @param request
     * @param response
     */
    @RequestMapping(value = "")
    public void accept(HttpServletRequest request, HttpServletResponse response){
        try {
            String method = ServletUtils.getRequest().getMethod();
            if("GET".equals(method)){
               super.doGet(request,response);
            }else{
                super.doPost(request,response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
