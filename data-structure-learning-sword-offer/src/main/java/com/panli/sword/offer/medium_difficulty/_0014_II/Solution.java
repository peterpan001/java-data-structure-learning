package com.panli.sword.offer.medium_difficulty._0014_II;

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
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (n * res % 1000000007);
    }
}
