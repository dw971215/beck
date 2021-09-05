package com.beck.weixin.utils;


/**
 * @Author dawei
 * @Date 2021/9/5 14:56
 */
public class WXStringUtil {

    /**
     * 数组转字符串
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String arryToString(T[] t){
        StringBuilder sr = new StringBuilder();
        for (T s : t) {
            sr.append(s);
        }
        return sr.toString();
    }
}
