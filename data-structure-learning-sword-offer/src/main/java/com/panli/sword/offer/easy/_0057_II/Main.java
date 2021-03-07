package com.panli.sword.offer.easy._0057_II;

import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * 采用 滑动窗口(双指针的一种变体) 的思想
     *      若 当前和 < 目标值，则：右边界右移
     *      若 当前和 > 目标值，则：左边界右移
     *      若 相等，则：
     *          1.将当前区间数，当做一个结果，存储为数组
     *          2.将 目标数组，存入结果数组
     *          3.左边界 右移，查找 之后的结果
     *
     *  因为 右边界一定大于左边界，因此，当 左边界到达目标值的一半后，就不需要再向后查找了
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        if (target <= 1) {
            return new int[0][0];
        }
        int leftIdx = 1;
        int rightIdx = 1;
        int curSum = 0;
        ArrayList<int[]> results = new ArrayList<>();
        while (leftIdx <= target / 2) {
            if (curSum < target) {
                curSum += rightIdx;
                rightIdx++;
            } else if (curSum > target) {
                curSum -= leftIdx;
                leftIdx++;
            } else {
                int[] resArr = new int[rightIdx - leftIdx];
                for (int i = leftIdx; i < rightIdx; i++) {
                    resArr[i - leftIdx] = i;
                }
                results.add(resArr);
                curSum -= leftIdx;
                leftIdx++;
            }
        }
        return results.toArray(new int[results.size()][]);
    }
}
