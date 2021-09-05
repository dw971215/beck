package com.beck.weixin.utils.sign;

import com.beck.common.utils.spring.SpringUtils;
import com.beck.weixin.config.WeiXinConfig;
import com.beck.weixin.constant.WXEncryConstant;
import com.beck.weixin.utils.WXStringUtil;
import com.beck.weixin.utils.digest.DigestUtil;

import java.util.Arrays;

/**
 * 签名验证
 * @Author dawei
 * @Date 2021/9/5 14:33
 */
public class SignUtil {

    /**
     * 微信配置类
     */
    public static WeiXinConfig weiXinConfig = SpringUtils.getBean(WeiXinConfig.class);

    /**
     * 微信开发者接入验证签名
     * 开发者通过检验signature对请求进行校验（下面有校验方式）。
     * 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，
     * 则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：
     * 1）将token、timestamp、nonce三个参数进行字典序排序(Arrays.sort)
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce){
        if(signature == null || timestamp == null || nonce == null){
            return  false;
        }
        final String TOKRN = weiXinConfig.getValitToken();
        String[] params = {TOKRN,timestamp,nonce};
        Arrays.sort(params);
        //排序后字符串
        String str = WXStringUtil.arryToString(params);
        //本地加密后的字符串
        String encode = DigestUtil.encode(WXEncryConstant.SHA1, str);
        return encode != null ? encode.equals(signature) : false;
    }
}
