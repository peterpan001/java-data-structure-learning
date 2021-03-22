package com.panli.interview.cards_in_a_row;

import java.util.Arrays;

/**
 * 判断5张扑克牌是否连续
 *
 * @author lipan
 * @date 2021-03-22
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        if (nums == null) {
            return false;
        }
        Arrays.sort(nums); // 将牌排序
        int zeroCount = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) { // 统计出大小王张数
                zeroCount++;
            } else if (nums[i] == nums[i + 1]) { // 扑克牌前一张不能等于后一张
                return false;
            }
        }
        return nums[4] - nums[zeroCount] <= 4; // 差值小于张数-1
    }
}
