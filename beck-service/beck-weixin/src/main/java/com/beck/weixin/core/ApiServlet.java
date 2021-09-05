package com.beck.weixin.core;

import com.beck.weixin.utils.sign.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * get post请求微信与第三方通信的基础类
 * @Author dawei
 * @Date 2021/9/5 14:25
 */
public abstract class ApiServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(ApiServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求传参数 进行utf-8编码
        req.setCharacterEncoding("UTF-8");
        //返回请求设置
        resp.setContentType("application/json; encoding=utf-8");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setCharacterEncoding("UTF-8");

        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        boolean flag = SignUtil.checkSignature(signature, timestamp, nonce);
        if(flag){
            logger.warn("微信开发者接入验证成功");
            resp.getWriter().write(echostr);
        }else{
            logger.warn("微信开发者接入验证失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
