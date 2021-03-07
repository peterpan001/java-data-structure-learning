package com.panli.sword.offer.easy._0065;

/**
 * 不用加减乘除做加法
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * 相加是异或操作，进位是 (a & b) << 1
     * 15 + 12 = 27
     * 不管进位先相加：
     * 个位：5+2=7，十位：1+1=2，
     * 无进位，故：20+7=27
     *
     * 99 + 111 =
     * 个、十、百位 的数字分别相加先不管进位的问题： 个位：9+1=0，十位：9+1=0，百位：1+0=1，相加得到：100
     * 进位：1+9=10，10+90=100，相加得到：110
     * 110+100=220；
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if (a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        int tempSum = 0, carrySum = 0;
        while (b != 0) { //进位的结果为0退出循环
            tempSum = a ^ b; // 不管进位先相加
            carrySum = (a & b) << 1; //进位
            a = tempSum;
            b = carrySum;
        }
        return a;
    }
}
