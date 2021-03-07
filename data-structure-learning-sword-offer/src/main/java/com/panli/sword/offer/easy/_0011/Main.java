package com.panli.sword.offer.easy._0011;

import java.util.Arrays;

/**
 * @author lipan
 * @date 2020-08-22
 * @desc 旋转数组的最小数字
 */
public class Main {

    /**
     * 暴力破解法：遍历一遍数组，找到其中的最小值
     *
     * @param numbers
     * @return
     */
    public int minArray_1(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        int minVal = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minVal) {
                minVal = numbers[i];
            }
        }
        return minVal;
    }

    /**
     * 借助数组api将其排序，排序后第一个元素即为目标值
     * @param numbers
     * @return
     */
    public int minArray_2(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        Arrays.sort(numbers);
        return numbers[0];
    }

}
