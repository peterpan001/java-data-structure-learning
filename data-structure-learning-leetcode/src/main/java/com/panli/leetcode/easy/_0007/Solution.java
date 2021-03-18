package com.panli.leetcode.easy._0007;

/**
 * 整数反转
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
