package com.panli.sort.bubble;

/**
 * 冒泡排序
 *
 * @author lipan
 * @date 2021-04-12
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 5, 4, 7, 6, 9, 8};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
