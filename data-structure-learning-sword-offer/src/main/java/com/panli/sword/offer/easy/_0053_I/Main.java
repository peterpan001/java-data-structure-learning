package com.panli.sword.offer.easy._0053_I;

/**
 * 在排序数组中查找数字
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * 借助二分法查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null) {
            throw new RuntimeException("数组为空");
        }
        return binarySearch(nums, target + 1) - binarySearch(nums, target);
    }

    public int binarySearch(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return leftIndex;
    }

    /**
     * 二分法查找左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int search_1(int[] nums, int target) {
        if (nums == null) {
            throw new RuntimeException("数组为空");
        }
        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        while (leftIdx <= rightIdx) {
            int middleIdx = leftIdx + (rightIdx - leftIdx) / 2;
            if (nums[middleIdx] == target) {
                rightIdx = middleIdx - 1;
            }
            if (nums[middleIdx] < target) {
                leftIdx = middleIdx + 1;
            }
            if (nums[middleIdx] > target) {
                rightIdx = middleIdx - 1;
            }
        }
        int count = 0;
        for (int i = leftIdx; i < nums.length; i++) {
            if (nums[i] == target) count++;
            if (nums[i] != target) break;
        }
        return count;
    }

}
