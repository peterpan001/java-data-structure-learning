package com.panli.sword.offer.medium_difficulty._0014_I;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        return 3 * f(n - 3);
    }

    private int f(int n) {
        if (n <= 4) {
            return n;
        }
        return 3 * f(n - 3);
    }
}
