package com.panli.sword.offer._0061;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) { //临界值判断
            return false;
        }
        Arrays.sort(nums);//将扑克牌排序
        int zeroCount = 0; //统计为大小王的牌的张数
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == nums[i + 1]) { //当前牌值不能和后一张牌值相等
                return false;
            }
        }
        return nums[4] - nums[zeroCount] <= 4; //牌的最大值和非大小王牌差值不能大于4
    }
}
