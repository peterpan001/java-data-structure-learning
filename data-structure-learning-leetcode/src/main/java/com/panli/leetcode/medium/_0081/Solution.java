package com.panli.leetcode.medium._0081;

import javax.swing.KeyStroke;

/**
 * 搜索旋转排序数组 II
 *
 * @author lipan
 * @date 2021-04-08
 */
public class Solution {

    /**
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分法查找
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int leftIdx = 0, rightIdx = len - 1;
        while (leftIdx <= rightIdx) {
            while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx + 1]) {
                leftIdx++;
            }
            while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx - 1]) {
                rightIdx--;
            }
            int midIdx = (leftIdx + rightIdx) / 2;
            if (nums[midIdx] == target) {
                return true;
            }
            if (nums[leftIdx] <= nums[midIdx]) {
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
        return false;
    }
}
