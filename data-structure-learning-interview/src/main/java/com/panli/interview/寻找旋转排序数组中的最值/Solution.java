package com.panli.interview.寻找旋转排序数组中的最值;

/**
 * 寻找旋转排序数组中的最大值/最小值
 *
 * @author lipan
 * @date 2021-03-29
 */
public class Solution {

    /**
     * [4,5,6,7,0,1,2]
     * 无重复元素的数组中，寻找最小值
     *
     * @param nums
     * @return
     */
    public static int findMinByNoRepeatEle(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int leftIdx = 0, rightIdx = nums.length - 1;
        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (nums[midIdx] > nums[rightIdx]) {
                leftIdx = midIdx + 1;
            } else if (nums[midIdx] < nums[rightIdx]) {
                rightIdx = midIdx;
            }
        }
        return nums[leftIdx];
    }

    /**
     * [4,5,6,6,7,0,1,1,2]
     * 有重复元素的数组中，寻找最小值
     *
     * @param nums
     * @return
     */
    public static int findMinByRepeatEle(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int leftIdx = 0, rightIdx = nums.length - 1;
        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (nums[midIdx] > nums[rightIdx]) {
                leftIdx = midIdx + 1;
            } else if (nums[midIdx] < nums[rightIdx]) {
                rightIdx = midIdx;
            } else {
                rightIdx--;
            }
        }
        return nums[leftIdx];
    }
}
