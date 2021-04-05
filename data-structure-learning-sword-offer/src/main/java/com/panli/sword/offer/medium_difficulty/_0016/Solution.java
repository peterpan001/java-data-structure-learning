package com.panli.sword.offer.medium_difficulty._0016;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double res = 1.0;
        for (int i = n; i != 0; i /= 2, x *= x) {
            if (i % 2 != 0) {
                res *= x;
            }
        }
        return n > 0 ? res : 1 / res;
    }
}
