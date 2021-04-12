package com.panli.sort.quick;

/**
 * @author lipan
 * @date 2020-08-16
 * @desc 快速排序
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 5, 3, 8, 7};
        quickSort(nums, 0, nums.length - 1);
        for (int tmp : nums) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int nums[], int low, int high) {
        if (low > high) { // 如果low大于high截止
            return;
        }
        int p = partition(nums, low, high); // 算出枢轴值
        quickSort(nums, low, p - 1); // 对左侧子数组进行递归排序
        quickSort(nums, p + 1, high); //对右侧子数组进行递归排序
    }

    private static int partition(int nums[], int low, int high) {
        int pivotKey = nums[low]; //用子表的第一个记录作为枢轴记录
        while (low < high) { //从表的两端交替向中间扫描
            while (low < high && nums[high] > pivotKey) {// 从数组后面向前扫描，将比pivotkey值小的交换到低端
                high--;
            }
            swap(nums, low, high);
            while (low < high && nums[low] < pivotKey) { // 从数组前面向后扫描，将比pivotkey值大的交换到高端
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
