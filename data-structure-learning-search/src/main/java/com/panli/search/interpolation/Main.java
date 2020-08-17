package com.panli.search.interpolation;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 插值查找算法
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int no = new Main().interpolationSearch(nums, 1);
        int no1 = new Main().interpolationSearch(nums, 3);
        int no2 = new Main().interpolationSearch(nums, 7);
        System.out.println(no);
        System.out.println(no1);
        System.out.println(no2);
    }

    public int interpolationSearch(int nums[], int target) {
        int mid, low = 0, high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low) * (target - nums[low]) / (nums[high] - nums[low]);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return high = mid - 1;
            }
            if (nums[mid] < target) {
                return low = mid + 1;
            }
        }
        return -1;
    }
}
