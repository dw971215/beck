package com.beck.weixin.utils.digest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 消息加密工具类
 * @Author dawei
 * @Date 2021/9/5 15:03
 */
public class DigestUtil {


    private static final char[] HEX_DIGES = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * 数据加密
     * @return
     */
    public static String encode(final String mode,final String content){
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance(mode);
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.getBytes("UTF-8"));
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return tmpStr;
    }


    /**
     * 字节转String
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            strDigest.append(byteToHexStr(byteArray[i]));
        }
        return strDigest.toString();
    }

    /**
     * 字节转16进制String
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] tempArr = new char[2];
        tempArr[0] = HEX_DIGES[(mByte >>> 4) & 0X0F];
        tempArr[1] = HEX_DIGES[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}
