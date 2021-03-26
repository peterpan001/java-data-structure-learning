package com.panli.common.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author lipan
 * @date 2021-03-23
 */
public class StringUtils {

    public static void main(String[] args) {
        try {
            System.out.println("中文a".getBytes("UTF-8").length); // 7
            System.out.println(StringUtils.getStrLength("中文a")); // 7
            System.out.println("中文a".length()); // 3
            System.out.println(subStringByBytes("中文a", 4)); //中
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回中英文字符串的字节长度
     *
     * @param str
     * @return
     */
    public static int getLength(String str) {
        try {
            return str.getBytes("UTF-8").length; // 一个中文占3个字节。
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 返回中英文字符串的字节长度
     *
     * @param str
     * @return
     */
    public static int getStrLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            //UTF-8编码格式中文占三个字节，GBK编码格式 中文占两个字节 ;
            len += (str.charAt(i) > 255 ? 3 : 1);
        }
        return len;
    }

    /**
     * 按字节截取字符串
     *
     * @param str
     * @param bytes
     * @return
     */
    public static String subStringByBytes(String str, int bytes) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            //GBK 编码格式 中文占两个字节 UTF-8 编码格式中文占三个字节;
            len += (str.charAt(i) > 255 ? 3 : 1);

            if (len > bytes) {
                return str.substring(0, i);
            }
        }
        return str;
    }
}
