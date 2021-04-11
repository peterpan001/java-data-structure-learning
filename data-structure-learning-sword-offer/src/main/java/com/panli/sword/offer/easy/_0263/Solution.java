package com.panli.sword.offer.easy._0263;

/**
 * 丑数：只包含质因数 2、3 和 5 的正整数。
 *
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
