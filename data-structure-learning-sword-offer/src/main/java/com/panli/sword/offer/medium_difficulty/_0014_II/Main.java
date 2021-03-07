package com.panli.sword.offer.medium_difficulty._0014_II;

/**
 * @author lipan
 * @date 2020-08-24
 * @desc 剪绳子-II
 */
public class Main {

    /**
     * 和剪绳子-I类似，不过是数值大了一些，需要按照要求进行按模取余
     *
     * @param n
     * @return
     */
    public int cuttingRope_1(int n) {
        long[] dp = new long[n + 7];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        if (n < 7) {
            return (int) dp[n];
        }
        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 3] * 3 % 1000000007;
        }
        return (int) dp[n];
    }

    /**
     * 剪绳子-I的方法还是一样可取，不过要注意取模的问题
     *
     * @param n
     * @return
     */
    public int cuttingRope_2(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int)(n * res % 1000000007);
    }

}
