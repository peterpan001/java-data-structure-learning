package com.panli.sword.offer.medium_difficulty._0056_I;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中数字出现的次数
 *
 * @author lipan
 * @date 2021-03-07
 */
public class Main {

    public int[] singleNumbers(int[] nums) {

        return null;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4, 2, 3};
        int[] ints = singleNumbers1(nums);
        System.out.println(ints);
    }

    public static int[] singleNumbers1(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;

        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static int minAbsDifference(int[] nums, int goal) {
        // dpSums[i]: 表示以i结尾所有子序列的和
        List<Integer>[] dpSums = new List[nums.length];
        int nearSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            dpSums[i] = new ArrayList<>();
            dpSums[i].add(nums[i]);
            if (i - 1 >= 0) {
                for (int sum : dpSums[i - 1]) {
                    dpSums[i].add(sum);
                    dpSums[i].add(sum + nums[i]);
                }
            }

            for (int sum : dpSums[i]) {
                if (Math.abs(sum - goal) <= Math.abs(nearSum - goal)) {
                    nearSum = sum;
                }
            }
        }
        return Math.abs(nearSum - goal);
    }
}
