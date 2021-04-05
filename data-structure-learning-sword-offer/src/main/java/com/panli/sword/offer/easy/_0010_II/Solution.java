package com.panli.sword.offer.easy._0010_II;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    public int numWays(int n) {
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
