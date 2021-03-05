package com.panli.sword.offer._0042;

/**
 * 连续子数组最大的和
 *
 * @author lipan
 * @date 2021-02-22
 */
public class Main {

    /**
     * [-2,1,-3,4,-1,2,1,-5,4]
     *
     * 思路：
     *    F(i) = 以 nums[i] 为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     *    F(i) = max(F(i-1) + nums[i], nums[i])
     *    res：所有子数组的和的最大值
     *    res = max(res, F(i))
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            throw new RuntimeException("数据为空");
        }
        int sum = nums[0];//保存每组的和
        int maxSum = nums[0];//连续子数组最大和
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
