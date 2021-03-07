package com.panli.sword.offer.easy._0057_I;

/**
 * 和为s的两个数字
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * 双指针解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || target <= 0) {
            return new int[0];
        }
        int lowIdx = 0;
        int highIdx = nums.length - 1;
        while (lowIdx < highIdx) {
            int res = nums[lowIdx] + nums[highIdx];
            if (res > target) { //两数之和 > 目标值，大数指针前移
                highIdx--;
            } else if (res < target) { //两数之和 < 目标值，小数指针后移
                lowIdx++;
            } else {
                return new int[]{nums[lowIdx], nums[highIdx]}; //两数之和 == 目标值，返回这两个数
            }
        }
        return new int[0];
    }
}
