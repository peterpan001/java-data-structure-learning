package com.panli.sword.offer.easy._0011;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    public int minArray(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        int leftIdx = 0, rightIdx = numbers.length - 1;
        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (numbers[midIdx] > numbers[rightIdx]) {
                leftIdx = midIdx + 1;
            } else if (numbers[midIdx] < numbers[rightIdx]) {
                rightIdx = midIdx;
            } else {
                rightIdx--;
            }
        }
        return numbers[leftIdx];
    }
}
