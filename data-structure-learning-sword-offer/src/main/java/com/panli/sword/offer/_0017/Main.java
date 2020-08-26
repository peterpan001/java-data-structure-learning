package com.panli.sword.offer._0017;

/**
 * @author lipan
 * @date 2020-08-26
 * @desc 打印从1到最大的n位数
 */
public class Main {

    /**
     * 求出最大的n位数的最大值+1为关键
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n); // 借助数学公式求出n位数的最大值+1，即可解答此题
        int[] res = new int[len - 1];
        for (int i = 1; i < len; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
