package com.panli.search.binary;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 二分查找算法
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int no = new Main().binarySearch1(nums, 1);
        int no1 = new Main().binarySearch1(nums, 5);
        int no2 = new Main().binarySearch1(nums, 7);
        System.out.println(no);
        System.out.println(no1);
        System.out.println(no2);
    }

    public int binarySearch(int nums[], int target) {
        int ins, low = 0, high = nums.length - 1;
        while (true) {
            ins = (low + high) / 2; //取数组中间元素下标
            if (nums[ins] == target) { // 与目标元素进行比较
                return ins;
            } else if (low > high) {
                return -1;
            } else {
                if (nums[ins] > target) { //如果大于目标元素，则在左半部分查找
                    high = ins - 1;
                } else { // 在右半部分查找
                    low = ins + 1;
                }
            }
        }
    }

    public int binarySearch1(int nums[], int target) {
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
