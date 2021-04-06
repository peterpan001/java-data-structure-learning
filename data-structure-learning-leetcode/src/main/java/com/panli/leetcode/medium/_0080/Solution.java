package com.panli.leetcode.medium._0080;

/**
 * 删除有序数组中的重复项 II
 *
 * @author lipan
 * @date 2021-04-06
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length; // 获取数组长度
        if (len <= 2) { // 如果数组长度小于等于 2，直接返回
            return len;
        }
        int slow = 2; // 定义起始位置：2
        for (int i = 2; i < nums.length; i++) { // 遍历数组
            if (nums[slow - 2] != nums[i]) { // 如果nums[slow-2] != nums[j]，将nums[j] 元素赋值给nums[slow];
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }
}
