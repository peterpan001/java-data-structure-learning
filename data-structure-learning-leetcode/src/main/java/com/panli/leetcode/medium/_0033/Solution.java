package com.panli.leetcode.medium._0033;

/**
 * 搜索旋转排序数组
 *
 * @author lipan
 * @date 2021-04-08
 */
public class Solution {


    /**
     * 暴力破解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法解决办法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int leftIdx = 0, rightIdx = len - 1;
        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (nums[midIdx] == target) {
                return midIdx;
            }
            if (nums[leftIdx] <= nums[midIdx]) { // [0, midIdx] 是有序的
                if (target >= nums[leftIdx] && target < nums[midIdx]) {
                    rightIdx = midIdx - 1;
                } else {
                    leftIdx = midIdx + 1;
                }
            } else {
                if (target <= nums[rightIdx] && target > nums[midIdx]) {
                    leftIdx = midIdx + 1;
                } else {
                    rightIdx = midIdx - 1;
                }
            }
        }
        return -1;
    }
}
