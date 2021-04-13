package com.panli.sort.quick;

/**
 * @author lipan
 * @date 2021-04-12
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 5, 4, 7, 6, 9, 8};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void quickSort(int nums[], int low, int high) {
        if (low > high) {
            return;
        }
        int p = partition(nums, low, high);
        quickSort(nums, low, p - 1);
        quickSort(nums, p + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivotKey = nums[low];
        while (low < high) {
            while (low < high && pivotKey < nums[high]) {
                high--;
            }
            swap(nums, low, high);
            while (low < high && pivotKey > nums[low]) {
                low++;
            }
            swap(nums, low, high);
        }
        return low;
    }

    private static void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
