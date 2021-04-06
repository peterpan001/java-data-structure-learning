package com.panli.leetcode.medium._0034;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author lipan
 * @date 2021-04-06
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private int findLastPosition(int nums[], int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2; // 向上取整，防止死循环
            if (nums[mid] > target) {
                // 下一轮搜索区间是[left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 下一轮搜索区间是[mid, right]
                left = mid;
            } else {
                // 下一轮搜索区间是[mid+1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    private int findFirstPosition(int nums[], int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                // 下一轮搜索区间是[left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 下一轮搜索区间是[left, mid]
                right = mid;
            } else {
                // 下一轮搜索区间是[mid+1, right]
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
