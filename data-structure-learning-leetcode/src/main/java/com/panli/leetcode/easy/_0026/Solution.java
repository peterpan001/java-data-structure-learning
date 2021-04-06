package com.panli.leetcode.easy._0026;

/**
 * 删除有序数组中的重复项
 *
 * @author lipan
 * @date 2021-04-01
 */
public class Solution {

    /**
     * 删除有序数组中的重复项
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) { // 如果数组为空，直接返回
            return 0;
        }
        int slow = 1; // 定义起始位置：1
        for (int j = 1; j < nums.length; j++) { // 遍历数组
            if (nums[slow - 1] != nums[j]) { // 如果nums[slow-1] != nums[j]，将nums[j] 元素赋值给nums[slow];
                nums[slow] = nums[j];
                slow++;
            }
        }
        return slow;
    }
}
