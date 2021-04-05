package com.panli.sword.offer.easy._0017;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    public int[] printNumbers(int n) {
        int len = 1;
        while (n > 0) {
            len *= 10;
            n--;
        }
        int[] res = new int[len - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
