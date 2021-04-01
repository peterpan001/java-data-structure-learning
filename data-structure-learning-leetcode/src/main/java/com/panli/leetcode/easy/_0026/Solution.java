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
        int i = 0; // 定义起始位置：0（不同数组元素的下标指针）
        for (int j = 1; j < nums.length; j++) { // 遍历数组
            if (nums[j] != nums[i]) { // 如果nums[j] != nums[i]，将nums[j] 元素赋值给nums[i+1];
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
