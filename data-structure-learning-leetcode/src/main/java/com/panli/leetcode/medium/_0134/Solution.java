package com.panli.leetcode.medium._0134;

/**
 * 加油站问题
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    /**
     * 加油站
     * <p>
     * 下图的黑色折线图即总油量剩余值，若要满足题目的要求：跑完全程再回到起点，总油量剩余值的任意部分都需要在X轴以上，且跑到终点时：总剩余汽油量 >= 0。
     * <p>
     * 1. 首先判断总gas能不能大于等于总cost，如果总gas不够，一切都白搭对吧（总（gas- cost）不用单独去计算，和找最低点时一起计算即可，只遍历一次）；
     * <p>
     * 2. 再就是找总（gas-cost）的最低点，不管正负（当然如果最低点都是正的话那肯定能跑完了）；
     * <p>
     * 3. 找到最低点后，如果有解，那么解就是最低点的下一个点，因为总（gas-cost）是大于等于0的，所以前面损失的gas我从最低点下一个点开始都会拿回来！
     * （此处@小马哥！），别管后面的趋势是先加后减还是先减后加，最终结果我是能填平前面的坑的。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainder = 0;
        int minRemainder = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < gas.length; i++) {
            remainder += gas[i] - cost[i];
            if (remainder < minRemainder) {
                minRemainder = remainder;
                minIdx = i;
            }
        }
        return remainder < 0 ? -1 : (minIdx + 1) % gas.length;
    }
}
