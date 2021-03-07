package com.panli.sword.offer.easy._0015;

/**
 * @author lipan
 * @date 2020-08-25
 * @desc 二进制中1的个数
 */
public class Main {

    /**
     * 相邻两个数与，结果值会变成较小的那个数，此时二进制中的1就会少1个，借助此思想可以解答此题
     * 例如：3&2=011&010=010
     *
     * @param n
     * @return
     */
    public int hammingWeight_1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & n - 1;
            res++;
        }
        return res;
    }

    /**
     * 二进制中的1的个数：可以让此二进制最右边的数每次都与1进行逻辑&，如果为1代表此末尾为1，否则为0，然后每次让此二进制右移一位（二进制数为正整数，最高位为0，故可忽略高位为1负数的情况）
     *
     * @param n
     * @return
     */
    public int hammingWeight_2(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
