package com.panli.search.sequential;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 顺序查找
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int no = new Main().sequentialSearch(nums, 5);
        System.out.println(no);
    }

    public int sequentialSearch(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) { // for循环遍历数组进行查找
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
