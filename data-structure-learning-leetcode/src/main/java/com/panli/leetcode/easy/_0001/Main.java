package com.panli.leetcode.easy._0001;

import java.util.HashMap;

/**
 * @author lipan
 * @date 2020-08-20
 * @desc 两数之和
 *
 * @solution 借助于HashMap的key-value结构，将nums[i]设为key，i设为value,每次寻找满足条件：
 * goal = target-nums[i]. 借助maps.containsKey(goal)判断是否存在，借助maps.get(goal)得到对应的下标
 */
public class Main {

    /**
     * 遍历数组：查找到满足 nums[i1] + nums[i2] = target
     * 时间复杂度O(n^2)
     * @param nums
     * @param target
     * @return 没有直接返回空，有则返回对于的元素所在下标
     */
    public int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for(int j = i +1; j < nums.length; j++){
                if(target == nums[i] + nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 借助于 HashMap，两次遍历，第一次填充值，第二次寻找目标值
     * 时间复杂度O(n),空间复杂度O(n)
     * @param nums
     * @param target
     * @return 没有直接返回空，有则返回对于的元素所在下标
     */
    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){ // 第一次遍历构造HashMap的：key-value，key为nums[i],value为i
            maps.put(nums[i], i);
        }
        for(int i = 0; i <  nums.length; i++){ // 借助HashMap特性寻找对应的值
            int goal = target - nums[i];
            if(maps.containsKey(goal) && maps.get(goal) != i){
                return new int[]{i, maps.get(nums[i])};
            }
        }
        return null;
    }

    /**
     * 借助于 HashMap，一次遍历
     * 时间复杂度O(n),空间复杂度O(n)
     * @param nums
     * @param target
     * @return 没有直接返回空，有则返回对于的元素所在下标
     */
    public int[] twoSum_3(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            if (maps.containsKey(goal)) {
                return new int[]{i, maps.get(goal)};
            }
            maps.put(nums[i], i);
        }
        return null;
    }

}
