package com.beck.weixin.constant;

/**
 * 有关二维码静态属性
 * @Author dawei
 * @Date 2021/9/3 16:24
 */
public class WXQRCodeConstant {

    /**
     * 二维码过期时间
     */
    public final static long EXPIRE_SECONDS = 60 * 60 * 24 * 15;//最大不超过30天 2592000


    /**
     * 二维码类型
     */
    public enum QRCodeTypeEnum{

        /**
         * 临时的整型参数值
         */
        QR_SCENE,

        /**
         * 临时的字符串参数值
         */
        QR_STR_SCENE,

        /**
         * 永久的整型参数值
         */
        QR_LIMIT_SCENE,

        /**
         * 永久的字符串参数值
         */
        QR_LIMIT_STR_SCENE
    }
}
