package com.panli.sort.merge;

/**
 * @author lipan
 * @date 2020-08-13
 * @desc 归并排序
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 5, 2, 3, 8, 7};
        new Main().mergeSort(nums, 0, nums.length - 1);
        for (int tmp : nums) {
            System.out.println(tmp);
        }
    }

    public void mergeSort(int[] nums, int low, int high) {

        // 判断是否只剩余一个元素
        if (low >= high) {
            return;
        }

        // 从中间将数组分成两个部分
        int middle = low + (high - low) / 2;

        // 分：递归左半部分
        mergeSort(nums, low, middle);

        // 分：递归右半部分
        mergeSort(nums, middle + 1, high);

        // 合：将排好序的左右两半合并
        mergeArray(nums, low, middle, high);
    }

    // 将排好序的左右两半合并
    private void mergeArray(int[] nums, int low, int middle, int high) {

        // 深克隆数组
        int[] copy = nums.clone();

        // idx代表修改数组位置，leftIdx代表左半部分的起始位置，rightIdx代表右半部分的起始位置
        int idx = low, leftIdx = low, rightIdx = middle + 1;

        // 结束条件：idx 大于等于 数组最大值
        while (idx <= high) {
            if (leftIdx > middle) { // 如果左半部分处理完毕，将右半部分拷贝进nums数组
                nums[idx++] = copy[rightIdx++];
            } else if (rightIdx > high) { // 如果右半部分处理完毕，将左半部分拷贝进nums数组
                nums[idx++] = copy[leftIdx++];
            } else if (copy[leftIdx] < copy[rightIdx]) { // 如果左指针数组元素小于有指针数组元素，将左指针数组元素拷贝进nums数组
                nums[idx++] = copy[leftIdx++];
            } else { // 否则将右指针数组元素拷贝进nums数组
                nums[idx++] = copy[rightIdx++];
            }
        }
    }
}
