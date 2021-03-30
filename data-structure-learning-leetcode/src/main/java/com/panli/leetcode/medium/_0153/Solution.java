package com.panli.leetcode.medium._0153;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author lipan
 * @date 2021-03-30
 */
public class Solution {

    /**
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null) { // 如果数组为空，直接返回-1
            return -1;
        }
        int leftIdx = 0, rightIdx = nums.length - 1; // 利用二分法
        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;  // 取中间元素
            if (nums[midIdx] > nums[rightIdx]) { // 如果中间元素值大于最右边元素值，则左指针右移
                leftIdx = midIdx + 1;
            } else { // 否则右指针左移
                rightIdx = midIdx;
            }
        }
        return nums[leftIdx]; // 返回左指针下标值
    }
}
