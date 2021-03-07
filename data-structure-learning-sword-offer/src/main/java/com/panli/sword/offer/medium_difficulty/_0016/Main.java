package com.panli.sword.offer.medium_difficulty._0016;

/**
 * @author lipan
 * @date 2020-08-25
 * @desc 数值的整数次方
 *  double Power(double base, int exponent)
 *  当exponent是0的时候，直接返回1即可，
 *  当exponent小于0的时候，需要把它转化为正数才能更方便计算，同时base要变为1/base。
 *  当exponent大于0的时候要分为两种情况，一种是偶数，一种是奇数。
 *  1，如果exponent是偶数我们只需要计算：Power(base*base, exponent/2)；比如我们要计算Power(3,8)，我们可以改为Power(3*3,8/2)，也就是Power(9,4)。
 *  2，如果exponent是奇数，我们只需要计算：base*Power(base*base, exponent/2)；比如Power(3,9)，我们只需要计算3*Power(3*3,9/2)，也就是3*Power(9,4)。
 */
public class Main {


    /**
     * 递归解决此题
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow_1(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1 / x * myPow_1(1 / x, -n - 1);  // n=Integer.MIN_VALUE时，-n会导致整型数字溢出，故此处采用-n-1
        }
        return (n % 2 == 0) ? myPow_1(x * x, n / 2) : x * myPow_1(x * x, n / 2);
    }

    /**
     * 非递归解决此问题
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow_2(double x, int n) {
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
