package com.panli.sword.offer.easy._0021;

/**
 * @author lipan
 * @date 2021-04-05
 */
public class Solution {

    public int[] exchange(int[] nums) {
        int leftIdx = 0, rightIdx = nums.length - 1;
        while (leftIdx < rightIdx) {
            while (nums[leftIdx] % 2 == 1 && leftIdx < rightIdx) {
                leftIdx++;
            }
            while (nums[rightIdx] % 2 == 0 && leftIdx < rightIdx) {
                rightIdx--;
            }
            int tmp = nums[leftIdx];
            nums[leftIdx] = nums[rightIdx];
            nums[rightIdx] = tmp;
            leftIdx++;
            rightIdx--;
        }
        return nums;
    }
}
