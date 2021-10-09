package com.beck.weixin.api;

import com.beck.common.utils.UrlUtil;
import com.beck.weixin.constant.WXQRCodeConstant;
import com.beck.weixin.core.WeiXinBaseApi;
import com.beck.weixin.core.qrcode.QRCodeApi;
import com.beck.weixin.core.token.OauthApi;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author dawei
 * @Date 2021/9/2 17:16
 */
@Api
@RestController
public class WeiXinApi extends WeiXinBaseApi {

    @RequestMapping(value = "/list")
    public String  test(HttpServletRequest request, HttpServletResponse response){
//        String accessToken = OauthApi.getAccessToken(weiXinConfig.getTestAppID(), weiXinConfig.getTestAppSecret());
        String resMsg = "";
        String urlMsg = "";
        try {
             urlMsg = QRCodeApi.createQRCodeImage(weiXinConfig.getTestAppID(), weiXinConfig.getTestAppSecret(),
                    123456, WXQRCodeConstant.QRCodeTypeEnum.QR_SCENE, WXQRCodeConstant.EXPIRE_SECONDS);
             resMsg = UrlUtil.downLoad(urlMsg, "公众号二维码", response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlMsg;
    }
    @RequestMapping(value = "/getToken")
    public String  getToken(HttpServletRequest request, HttpServletResponse response){
        String accessToken = OauthApi.getAccessToken("wx9c352a6148d7753d", "5dba8fb15a504e75bd8c8247af5b8971");

//        String urlMsg = "";
//        try {
//            urlMsg = QRCodeApi.createQRCodeImage(weiXinConfig.getTestAppID(), weiXinConfig.getTestAppSecret(),
//                    123456, WXQRCodeConstant.QRCodeTypeEnum.QR_SCENE, WXQRCodeConstant.EXPIRE_SECONDS);
//             UrlOperationUtil.downLoad(urlMsg, "公众号二维码", response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return accessToken;
    }
}
