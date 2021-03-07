package com.panli.sword.offer.easy._0039;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * @date 2020-11-28
 * @desc 数组中出现次数超过一半的数字
 */
public class Main {

    /**
     * 借助集合API给无序数组排序，超过一半的数字肯定中位数即为所找结果
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * @param nums
     * @return
     */
    public int majorityElement_1(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!numMap.containsKey(nums[i])) {
                numMap.put(nums[i], 1);
            } else {
                numMap.put(nums[i], numMap.get(nums[i]) + 1);
            }
            if (numMap.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }
}
