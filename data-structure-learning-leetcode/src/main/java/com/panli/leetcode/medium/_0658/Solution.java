package com.panli.leetcode.medium._0658;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到K个最接近的元素
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        if (arr == null || k <= 0) {
            return list;
        }
        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        int rmIdx = arr.length - k;
        while (rmIdx > 0) {
            if (x - arr[leftIdx] <= arr[rightIdx] - x) {
                rightIdx--;
            } else {
                leftIdx++;
            }
            rmIdx--;
        }
        for (int i = leftIdx; i < leftIdx + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
