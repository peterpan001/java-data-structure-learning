package com.panli.sword.offer.medium_difficulty._0064;

/**
 * 求1+2+...+n
 *
 * @author lipan
 * @date 2021-03-07
 */
public class Main {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
