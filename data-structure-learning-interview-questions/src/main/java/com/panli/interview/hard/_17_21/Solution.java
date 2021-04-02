package com.panli.interview.hard._17_21;

/**
 * 直方图的水量
 *
 * @author lipan
 * @date 2021-04-02
 */
public class Solution {

    /**
     * 直方图的水量，利用双指针
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length <= 2) { // 如果长度为0、1、2，直接返回0
            return 0;
        }
        int leftIdx = 0, rightIdx = height.length - 1; // 声明左右指针
        int leftMax = 0, rightMax = 0; // 声明左右最大值
        int res = 0; // 存储结果值
        while (leftIdx < rightIdx) { // 退出条件：左指针 >= 右指针
            leftMax = Math.max(leftMax, height[leftIdx]);
            rightMax = Math.max(rightMax, height[rightIdx]);
            if (height[leftIdx] < height[rightIdx]) { // 如果左指针值小于右指针值
                res += leftMax - height[leftIdx]; // 左边处理，最大值减去当前值即为蓄水量
                leftIdx++;
            } else {
                res += rightMax - height[rightIdx]; // 右边处理，最大值减去当前值即为蓄水量
                rightIdx--;
            }
        }
        return res;
    }
}
