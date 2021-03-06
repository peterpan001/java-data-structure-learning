package com.panli.sword.offer._0058_II;

/**
 * 左旋转字符串
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * 单词翻转
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null || n <= 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = n; i < n + length; i++) {
            sb.append(s.charAt(i % length));
        }
        return sb.toString();
    }
}
