package com.panli.sword.offer._0021;

/**
 * @author lipan
 * @date 2020-08-27
 * @desc 调整数组顺序使奇数位于偶数前面
 */
public class Main {

    /**
     * 双指针实现
     *
     * @param nums
     * @return
     */
    public int[] exchange_1(int[] nums) {
        if (nums == null || nums.length == 0) { // 非空校验
            return nums;
        }
        int oddIdx = 0, evenIdx = nums.length - 1; // 取左右临界值
        while (oddIdx < evenIdx) {
            while (oddIdx < evenIdx && nums[oddIdx] % 2 != 0) { // 左边如果是奇数就一直递增加
                oddIdx++;
            }
            while (oddIdx < evenIdx && nums[evenIdx] % 2 == 0) { // 右边如果是偶数就一直递减
                evenIdx++;
            }
            if (oddIdx < evenIdx) {
                int tmp = nums[oddIdx]; // 左边索引和右边索引所指向的都是需要交换的元素位置，直接交换就行
                nums[oddIdx] = nums[evenIdx];
                nums[evenIdx] = tmp;
            }
        }
        return nums;
    }

    /**
     * 暴力解法，遍历一遍数组，奇数放前面，偶数放后面
     *
     * @param nums
     * @return
     */
    public int[] exchange_2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] tmp = new int[nums.length];
        int oddIdx = 0, evenIdx = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                tmp[oddIdx++] = nums[i];
            } else {
                tmp[evenIdx--] = nums[i];
            }
        }
        return tmp;
    }
}
