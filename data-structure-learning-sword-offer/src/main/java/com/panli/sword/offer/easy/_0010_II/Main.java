package com.panli.sword.offer.easy._0010_II;

/**
 * @author lipan
 * @date 2020-08-21
 * @desc 青蛙跳台阶问题，其本质和斐波那契数列一样，不过初始值不一样
 */
public class Main {

    /**
     * 采用递归的方法解决：当n很大时会因递归栈深度太深引起超时
     *
     * @param n
     * @return
     */
    public int numWays_1(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return numWays_1(n - 1) % 1000000007 + numWays_1(n - 2) % 1000000007;
    }

    /**
     * 青蛙跳台阶问题：非递归方法实现
     *
     * @param n
     * @return
     */
    public int numWays_2(int n) {
        if (n <= 1) { // n<=1时，只能跳1阶;
            return 1;
        }
        if (n == 2) { // n==2时，有两种跳法:直接跳2阶；一阶一阶跳；
            return 2;
        }
        int first = 1, second = 2;
        while (n > 2) { // n>2时，相当于numWays(n) = numWays(n-1) + numWays(n-2)
            int tmp = first + second;
            first = second % 1000000007;
            second = tmp % 1000000007;
            n--;
        }
        return second;
    }

}
