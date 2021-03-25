package com.panli.interview.array_find_sum_k;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 有序的整数数组[2,3,5,7,9,10,11,12,13,14]，寻找满足[]+[]=K条件的值。
 * 如果 K=12，则输出(2,10)(3,9)(5,7)组合的对，要求时间和空间复杂度尽可能的低。
 *
 * @author lipan
 * @date 2021-03-25
 */
public class Solution {


    public static List<int[]> findSumKByArray(int[] nums, int k) {
        List<int[]> list = new ArrayList<>();
        // 边界条件，数组为空，或者数组首元素大于k 都直接返回空
        if (nums == null) {
            return list;
        }
        if (nums[0] >= k || nums.length == 1) {
            return list;
        }
        int leftIdx = 0, rightIdx = nums.length - 1;
        while (nums[leftIdx] * 2 <= k) {
            if (nums[leftIdx] + nums[rightIdx] == k) {
                list.add(new int[]{nums[leftIdx], nums[rightIdx]});
                leftIdx++;
                rightIdx = nums.length - 1;
            }else if(nums[leftIdx] + nums[rightIdx] > k){
                rightIdx--;
            }
            if(leftIdx == rightIdx){
                leftIdx++;
                rightIdx = nums.length - 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5,7,9,10,11,12,13,14};
        List<int[]> sumKByArray = findSumKByArray(nums, 12);
        System.out.println(JSONArray.toJSON(sumKByArray));
    }
}
