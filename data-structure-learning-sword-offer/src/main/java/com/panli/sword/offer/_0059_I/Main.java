package com.panli.sword.offer._0059_I;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //初始化校验
        if (nums == null || k <= 0) {
            return new int[0];
        }
        //保存结果值
        int[] res = new int[nums.length - k + 1];
        //申请单调递增双端队列保存窗口值
        Deque<Integer> deque = new LinkedList<>();
        int arrIdx = 0;
        for (int i = 0; i < k; i++) { //将第一个窗口元素放入双端递增队列中
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) { //如果队尾元素小于当前值，队尾元素出队列
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
        }
        res[arrIdx++] = deque.peekFirst(); //第一个窗口最大值
        for (int j = k; j < nums.length; j++) {
            if (nums[j - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.offerLast(nums[j]);
            res[arrIdx++] = deque.peekFirst();//循环每遍历一次都是当前窗口最大值
        }
        return res;
    }
}
