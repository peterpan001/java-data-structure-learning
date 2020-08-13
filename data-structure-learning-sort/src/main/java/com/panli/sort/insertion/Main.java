package com.panli.sort.insertion;

/**
 * @author lipan
 * @date 2020-08-12
 * @desc 插入排序
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 6, 2, 8, 7};
        new Main().insertionSort(nums);
        for (int tmp : nums) {
            System.out.println(tmp);
        }
    }

    public void insertionSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        // 假设第一个数是已经拍好序的，故从第二个数开始遍历数组
        for (int i = 1, j; i < nums.length; i++) {
            // 外围开始循环，把当前i指向的值用current保存
            int current = nums[i];
            // 指针 j 内循环，和 current 值比较，若 j 所指向的值比 current 值大，则该数右移一位
            for (j = i; j >= 0 && nums[j - 1] > current; j--) {
                nums[j] = nums[j - 1];
            }
            // 内循环结束，j+1 所指向的位置就是 current 值插入的位置
            nums[j] = current;
        }
    }
}
