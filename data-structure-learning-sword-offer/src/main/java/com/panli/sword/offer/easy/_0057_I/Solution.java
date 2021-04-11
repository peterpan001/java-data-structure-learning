package com.panli.sword.offer.easy._0057_I;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        if(len <= 1){
            return new int[0];
        }
        int leftIdx = 0, rightIdx = len - 1;
        while(leftIdx < rightIdx){
            int sum = nums[leftIdx] + nums[rightIdx];
            if(sum < target){
                leftIdx++;
            }else if(sum > target){
                rightIdx--;
            }else{
                return new int[]{nums[leftIdx], nums[rightIdx]};
            }
        }
        return new int[0];
    }

    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        if(len <= 1){
            return new int[0];
        }
        int leftIdx = 0, rightIdx = len - 1;
        while(nums[leftIdx] * 2 < target){
            int res = target - nums[leftIdx];
            while(res < nums[rightIdx]){
                rightIdx --;
            }
            if(res == nums[rightIdx]){
                return new int[]{nums[leftIdx], nums[rightIdx]};
            }
            leftIdx++;
            rightIdx = len - 1;
        }
        return new int[0];
    }
}
