package com.beck.weixin.error;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author dawei
 * @Date 2021/9/2 20:20
 */
public class WXErrCode {


    /**
     * 微信错误信息文字提示
     * @param res
     * @return
     */
    public static String WXErrMsg(JSONObject res){
        String code = res.getString("errcode");
        String msg = "";
        switch (code){
            case "40001":
                msg =  "AppSecret错误或者AppSecret不属于这个公众号，请开发者确认AppSecret的正确性";
             break;
            case "40002":
                msg = "请确保grant_type字段值为client_credential";
            break;
            case "40164":
                msg = "调用接口的IP地址不在白名单中，请在接口IP白名单中进行设置。";
            break;
            case "89503":
                msg =  "此IP调用需要管理员确认,请联系管理员";
            break;
            case "89501":
                msg =  "此IP正在等待管理员确认,请联系管理员";
            break;
            case "89506":
                msg =  "24小时内该IP被管理员拒绝调用两次，24小时内不可再使用该IP调用";
            break;
            case "89507":
                msg =  "1小时内该IP被管理员拒绝调用一次，1小时内不可再使用该IP调用";
            break;
            case "40003":
                msg =  "不合法的 OpenID ，请开发者确认 OpenID （该用户）是否已关注公众号，或是否是其他公众号的 OpenID";
                break;
            case "40014":
                msg =  "不合法的 access_token ，请开发者认真比对 access_token 的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口";
                break;
            case "40039":
                msg =  "不合法的 URL 长度";
                break;
            case "41001":
                msg =  "缺少 access_token 参数";
                break;
            case "41002":
                msg =  "缺少 appid 参数";
                break;
            case "41004":
                msg =  "缺少 secret 参数";
                break;
            case "42001":
                msg =  "access_token 超时，请检查 access_token 的有效期，请参考基础支持 - 获取 access_token 中，对 access_token 的详细机制说明";
                break;
            case "40125":
                msg =  "无效的appsecret";
                break;
            case "40013":
                msg =  "不合法的 AppID ，请开发者检查 AppID 的正确性，避免异常字符，注意大小写";
                break;
            case "48001":
                msg =  "api 功能未授权，请确认公众号已获得该接口，可以在公众平台官网 - 开发者中心页中查看接口权限";
                break;
            case "50002":
                msg =  "用户受限，可能是违规后接口被封禁";
                break;


            default:
                msg = "未知错误，请联系管理员";
        }
        return msg;
    }
}
