package com.panli.leetcode.difficult._0154;

/**
 * 寻找旋转排序数字中的最小值 II
 *
 * @author lipan
 * @date 2021-03-30
 */
public class Solution {

    /**
     * 找最小值，要偏向左找，目标值右边的情况会比较简单，容易区分，所以比较mid与right而不比较mid与left
     *
     * 每次进入无序的那部分找出最小值,但是由于有重复值的情况, 需要加入 mid 元素等于 hi 元素的情况
     * 此时应该将 hi 减 1 防止重复数字是最小元素
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null) { // 如果数组为空，直接返回-1
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
