package com.panli.interview.两个有序数组合并;

/**
 * a[2,3,10,25,60]、b[1,3,9,11,26,63]两个有序数组，编写代码将两个数组合并为一个整体有序的数组
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    public static void main(String[] args) {
        int a[] = new int[]{2, 3, 10, 25, 60};
        int b[] = new int[]{1, 3, 9, 11, 26, 63};
        int[] nums = mergeArray(a, b);
        for(int num : nums){
            System.out.println(num);
        }
    }

    public static int[] mergeArray(int nums1[], int nums2[]) {
        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }
        int nums[] = new int[nums1.length + nums2.length];
        int numsIdx = nums.length - 1;
        int nums1Idx = nums1.length - 1;
        int nums2Idx = nums2.length - 1;
        while (nums1Idx >= 0 && nums2Idx >= 0) {
            nums[numsIdx--] = nums1[nums1Idx] > nums2[nums2Idx] ? nums1[nums1Idx--] : nums2[nums2Idx--];
        }
        while (nums1Idx >= 0) {
            nums[numsIdx--] = nums1[nums1Idx--];
        }
        while (nums2Idx >= 0) {
            nums[numsIdx--] = nums2[nums2Idx--];
        }
        return nums;
    }
}
