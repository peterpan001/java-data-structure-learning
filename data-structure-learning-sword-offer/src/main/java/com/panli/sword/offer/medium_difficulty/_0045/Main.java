package com.panli.sword.offer.medium_difficulty._0045;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 *
 * @author lipan
 * @date 2021-03-07
 */
public class Main {

    public String minNumber(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        String[] nums2Str = new String[len];
        for (int i = 0; i < len; i++) {
            nums2Str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(nums2Str, (a, b) -> {
            return (a + b).compareTo(b + a);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(nums2Str[i]);
        }
        return sb.toString();
    }
}
