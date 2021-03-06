package com.panli.sword.offer._0053_II;

/**
 * 0~n-1中缺失的数字
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    public int missingNumber(int[] nums) {
        if (nums == null) {
            throw new RuntimeException("数组为空");
        }
        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        while (leftIdx <= rightIdx) {
            int middleIdx = leftIdx + (rightIdx - leftIdx) / 2;
            if (nums[middleIdx] == middleIdx) {
                leftIdx = middleIdx + 1;
            } else {
                rightIdx = middleIdx - 1;
            }
        }
        if (leftIdx == nums.length - 1 && nums[leftIdx] == leftIdx) {
            leftIdx++;
        }
        return leftIdx;
    }
}
