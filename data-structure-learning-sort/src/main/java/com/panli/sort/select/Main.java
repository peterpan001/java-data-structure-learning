package com.panli.sort.select;

/**
 * @author lipan
 * @date 2020-08-16
 * @desc 简单选择排序
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 5, 2, 3, 8, 7};
        new Main().simpleSelectSort(nums);
        for (int tmp : nums) {
            System.out.println(tmp);
        }
    }

    public void simpleSelectSort(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i; //每次都假设起始元素为最小值
            for (int j = i + 1; j < nums.length; j++) { //从第i+1个元素中寻找最小的元素
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, i, minIdx);//交换
        }
    }

    private void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
