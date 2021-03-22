package com.panli.interview.string_addition;

/**
 * 两个字符串相加
 *
 * @author lipan
 * @date 2021-03-22
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        } else if (num2 == null) {
            return num1;
        }
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1, add = 0;
        StringBuilder sb = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || add != 0) {
            int x = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int y = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int result = x + y + add;
            sb.append(result % 10);
            add = result / 10;
            idx1--;
            idx2--;
        }
        sb.reverse();
        return sb.toString();
    }
}
