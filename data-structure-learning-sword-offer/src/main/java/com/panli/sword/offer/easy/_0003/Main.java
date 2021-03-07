package com.panli.sword.offer.easy._0003;

import java.util.HashSet;

/**
 * @author lipan
 * @date 2020-08-21
 * @desc 数组中重复的数字
 */
public class Main {


    // 借助 HashSet，每个元素只能放一个，如果set集合中包含此元素则直接返回即可
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> sets = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (sets.contains(nums[i])) {
                return nums[i];
            }
            sets.add(nums[i]);
        }
        return -1; // 没找到返回-1
    }
}
