package com.panli.leetcode.medium._0781;

import java.util.HashMap;
import java.util.Map;

/**
 * 森林中的兔子
 *
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    /**
     * 思路：
     *  用hash来统计answers中每个数字出现的次数； 然后就是开始处理哈希表里面的统计结果了；
     *  例如， 5出现了8次， 那么至少得2*（5+1）只兔子； 如果5出现了6次呢？ 至少需要6只兔子；如果5出现了3次呢？ 还是6只兔子；
     *
     *  当val出现了t次，
     *      如果t%（val+1） == 0， 需要（t/（val+1））*（val+1）只兔子；
     *      如果没有整除， 则至少需要(t/(val+1)+1)*(val+1)只兔子；
     *
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers) {
        if (answers == null) { // 如果数组为空，直接返回0
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int answer : answers) {
            count.put(answer, count.getOrDefault(answer, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int type = entry.getKey(), times = entry.getValue();
            if (times % (type + 1) == 0) {
                res += times;
            } else {
                res += (times / (type + 1) + 1) * (type + 1);
            }
        }
        return res;
    }
}
