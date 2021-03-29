package com.panli.interview.微信红包;

/**
 * 微信红包算法
 *
 * @author lipan
 * @date 2021-03-19
 */
public class RedPackage1 {

    /**
     * random
     *
     * @param totalMoney
     * @param totalNums
     * @return
     */
    public static double[] getRanomMoney(double totalMoney, int totalNums) {
        double[] moneyArr = new double[totalNums];
        int idx = 0;
        while (totalNums > 1) {
            double maxMoney = totalMoney / totalNums * 2;
            double randomMoney = Math.random() * maxMoney;
            randomMoney = randomMoney < 0.01 ? 0.01 : randomMoney;
            randomMoney = Math.round(randomMoney * 100) / 100d;
            moneyArr[idx++] = randomMoney;
            totalNums--;
            totalMoney -= randomMoney;
        }
        moneyArr[idx] = Math.round(totalMoney * 100) / 100d;
        return moneyArr;
    }

    public static void main(String[] args) {
        double[] ranomMoney = getRanomMoney(10, 3);
        for (double d : ranomMoney) {
            System.out.println(d);
        }
    }
}
