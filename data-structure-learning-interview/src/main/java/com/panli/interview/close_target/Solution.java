package com.panli.interview.close_target;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 完成以下函数：给定一个升序排列的数组 arrays，要求在数组中找到最接近 target 的 num 个数。
 * 返回结果必须是按升序排列的
 * <p>
 * 补充：假设A、B两数与target相差相等，取小的一个最为最近的值。如1、5与3相差2，1<5，取1
 * <p>
 * Sample：
 * 输入：arrays = [1,2,3,4,5], num = 4, target = 3
 * 输出：[1,2,3,4]
 * Sample：
 * 输入：arrays = [1,2,3,4,5], num = 4, target = -1
 * 输出：[1,2,3,4]
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    private static List<Integer> getLatestNums(int[] arrays, int target, int num) {
        if (arrays == null || num <= 0) {
            return null;
        }
        List<Integer> res = Arrays.stream(arrays).boxed().collect(Collectors.toList());
        Collections.sort(res, (a, b) -> a == b ? a - b : Math.abs(a - target) - Math.abs(b - target));
        res = res.subList(0, num);
        Collections.sort(res);
        return res;
    }

}
