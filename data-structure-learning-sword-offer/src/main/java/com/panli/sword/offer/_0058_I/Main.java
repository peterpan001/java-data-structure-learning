package com.panli.sword.offer._0058_I;

/**
 * 翻转单词顺序
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * 单次翻转
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] wordArrs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = wordArrs.length - 1; i >= 0; i--) {
            if (wordArrs[i].equals("")) continue;
            sb.append(wordArrs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
