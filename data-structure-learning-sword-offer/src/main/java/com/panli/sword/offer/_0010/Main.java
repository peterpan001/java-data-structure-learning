package com.panli.sword.offer._0010;

/**
 * @author lipan
 * @date 2020-08-21
 * @desc 斐波那契数列
 */
public class Main {

    /**
     * 递归法求解：在递归栈的深度较小时比较好用，但是n很大时，会因栈的深度过深，造成超时
     * 其本质为：从上到下，再回归到上
     *
     * @param n
     * @return
     */
    public int fib_1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib_1(n - 1) % 1000000007 + fib_1(n - 2) % 1000000007;
    }

    /**
     * 非递归法求解
     * 其本质为：直接从下找到对应的上
     *
     * @param n
     * @return
     */
    public int fib_2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0, second = 1;
        while (n > 0) {
            int tmp = first + second;
            first = second % 1000000007;
            second = tmp % 1000000007;
            n--;
        }
        return first;
    }
}
