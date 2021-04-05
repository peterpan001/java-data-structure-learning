package com.panli.sword.offer.easy._0005;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
