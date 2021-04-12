package com.panli.leetcode.medium._0179;

import java.util.Arrays;

/**
 * 最大数
 * <p>
 * a.compareTo(b)：它是从头开始比较对应字符的大小(ASCII码顺序)
 * 如果a的第一个字符和b的第一个字符不等，结束比较，返回他们之间的长度差值
 * 如果a的第一个字符和b的第一个字符相等，则a的第二个字符和b的第二个字符做比较
 * 以此类推,直至比较的字符或被比较的字符有一方结束。
 *
 * @author lipan
 * @date 2021-04-12
 */
public class Solution {

    public String largestNumber(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        String[] nums2Str = new String[len];
        for (int i = 0; i < len; i++) {
            nums2Str[i] = String.valueOf(nums[i]);
        }

        // (b+a).compareTo(a+b),如果大于0,Comparator接收返回值为正数，就会交换a和b
        Arrays.sort(nums2Str, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        if (nums2Str[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(nums2Str[i]);
        }
        return sb.toString();
    }
}
