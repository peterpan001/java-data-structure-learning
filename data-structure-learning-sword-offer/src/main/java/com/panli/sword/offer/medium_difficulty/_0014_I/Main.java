package com.panli.sword.offer.medium_difficulty._0014_I;

/**
 * @author lipan
 * @date 2020-08-24
 * @desc 剪绳子-I
 */
public class Main {

    /**
     * 递归的方法解答此题
     * 根343题一样，f(x)=(n/x)^x 求极值，(n/x)=e时取最大值，e=2.7约等于3，所以把n拆成尽可能多的3就行了
     * <p>
     * 当n = 2时，可以拆成 1，1；1*1=1
     * 当n = 3时，可以拆成 1，2；1*2=2
     * 当n = 4时，可以拆成 2，2；2*2=4
     * <p>
     * 当n = 5时，可以拆成 2，3；3* 2=6
     * 当n = 6时，可以拆成 3，3；3* 3=9
     * 当n = 7时，可以拆成 3，4；3* 4=12
     * <p>
     * 当n = 8时，可以拆成 3，5；3*f(5)=18
     * 当n = 9时，可以拆成 3，6；3*f(6)=27
     * ...
     *
     * @param n
     * @return
     */
    public int cuttingRope_1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        return f(n);
    }

    private int f(int n) {
        if (n <= 4) {
            return n;
        }
        return 3 * f(n - 3);
    }

    /**
     * 当n = 0时，结果为0
     * 当n = 1是，结果为0
     * 当n = 2时，可以拆成 1，1；1*1=1
     * 当n = 3时，可以拆成 1，2；1*2=2
     * 当n = 4时，可以拆成 2，2；2*2=4
     * 当n = 5时，可以拆成 2，3；3* 2=6
     * 当n = 6时，可以拆成 3，3；3* 3=9
     * <p>
     * 当n = 7时，可以拆成 3，4；3* 4=3*f(4)=12
     * 当n = 8时，可以拆成 3，5；3*f(5)=18
     * 当n = 9时，可以拆成 3，6；3*f(6)=27
     *
     * @param n
     * @return
     */
    public int cuttingRope_2(int n) {
        int[] res = new int[n + 7]; //初始化赋值7个元素，故数组大小最小初始化应为7
        res[0] = 0;
        res[1] = 0;
        res[2] = 1;
        res[3] = 2;
        res[4] = 4;
        res[5] = 6;
        res[6] = 9;
        if (n <= 6) {
            return res[n];
        }
        for (int i = 7; i <= n; i++) {
            res[i] = res[i - 3] * 3;
        }
        return res[n];
    }

    /**
     * 和方法一类似
     *
     * @param n
     * @return
     */
    public int cuttingRope_3(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int res = 1;
        while (n > 4) {
            res = res * 3;
            n = n - 3;
        }
        return n * res;
    }
}
