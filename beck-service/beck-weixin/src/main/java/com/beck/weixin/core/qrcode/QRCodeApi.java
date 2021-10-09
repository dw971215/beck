package com.beck.weixin.core.qrcode;

import com.alibaba.fastjson.JSONObject;
import com.beck.common.utils.http.HttpUtils;
import com.beck.weixin.constant.WXQRCodeConstant;
import com.beck.weixin.constant.WXApiUrlConstant;
import com.beck.weixin.core.token.OauthApi;
import com.beck.weixin.error.WXErrCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import static com.beck.common.utils.UrlUtil.buildReqUrl;

/**
 * 生成公众号二维码图片
 * @Author dawei
 * @Date 2021/9/3 16:08
 */
public class QRCodeApi {

    private static Logger logger = LoggerFactory.getLogger(QRCodeApi.class);

    /**
     * 生成微信公众号二维码图片
     * @param appId
     * @param appSecret
     * @param sceneContent 参数
     * @param typeEnum 二维码类型
     * @param expire_seconds 过期时间
     * @return
     */
    public static String createQRCodeImage(String appId, String appSecret, Object sceneContent,
                                           WXQRCodeConstant.QRCodeTypeEnum typeEnum, long expire_seconds){
        //获取token
        String access_token = OauthApi.getAccessToken(appId,appSecret);
        //请求参数定义
        JSONObject param = new JSONObject();
        //有效期
        param.put("expire_seconds", expire_seconds);
        //二维码类型
        param.put("action_name", typeEnum);
        HashMap<String,HashMap<String,Object>> scene = new HashMap<>();
        //传参数内容
        HashMap<String,Object> scene_id = new HashMap<>();
        scene_id.put("scene_id",sceneContent);

        scene.put("scene",scene_id);
        param.put("action_info",scene);
        String qrResult = HttpUtils.sendPost(WXApiUrlConstant.create_qrcode_url + access_token, param.toJSONString());
        //根据返回的ticket 获取图片网络地址
        JSONObject object = JSONObject.parseObject(qrResult);
        if(object.get("ticket")!=null){
           return showQRCodeImage(object.get("ticket").toString());
        }
        String errMsg = WXErrCode.WXErrMsg(object);
        logger.info(errMsg);
        return errMsg;
    }

    /**
     * 获取显示二维码地址
     * @param ticket
     * @return
     */
    public static String showQRCodeImage(String ticket){
        HashMap<String,String> param = new HashMap<>();
        param.put("ticket",ticket);
        String url = buildReqUrl(WXApiUrlConstant.show_qrcode_url,param);
        return url;
    }

}
