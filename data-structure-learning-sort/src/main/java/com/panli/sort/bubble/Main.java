package com.panli.sort.bubble;

/**
 * @author lipan
 * @date 2020-08-12
 * @desc 冒泡排序
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 6, 3, 9, 8, 7};

        bubbleSort(nums);

        for (int tmp : nums) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        // 定义boolean变量，标记每轮遍历中是否发生了数组元素交换
        boolean hasChange = true;
        // 每轮遍历开始都将hasChange置为false
        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < nums.length - i - 1; j++) {

                // 进行两两比较，如果发现当前数比下一个数大时，进行交换，并将hasChange置为true
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    hasChange = true;
                }
            }
        }
    }

    /**
     * 交换数组元素位置
     *
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
