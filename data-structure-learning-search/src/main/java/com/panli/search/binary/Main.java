package com.panli.search.binary;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 二分查找算法
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int no = new Main().binarySearch(nums, 1);
        int no1 = new Main().binarySearch(nums, 5);
        int no2 = new Main().binarySearch(nums, 7);
        System.out.println(no);
        System.out.println(no1);
        System.out.println(no2);
    }

    /**
     * 二分查找算法
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int nums[], int target) {
        int mid, low = 0, high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
