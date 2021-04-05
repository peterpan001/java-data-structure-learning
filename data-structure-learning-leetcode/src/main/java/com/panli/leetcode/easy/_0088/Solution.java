package com.panli.leetcode.easy._0088;

/**
 * 合并两个有序数组
 *
 * @author lipan
 * @date 2021-04-05
 */
public class Solution {

    /**
     * 开辟 O(m+n)的空间
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeArr = new int[m + n];
        int m1 = 0, n1 = 0, cur = 0;
        while (m1 < m || n1 < n) {
            if (m1 == m) {
                mergeArr[cur] = nums2[n1++];
            } else if (n1 == n) {
                mergeArr[cur] = nums1[m1++];
            } else if (nums1[m1] <= nums2[n1]) {
                mergeArr[cur] = nums1[m1];
                m1++;
            } else {
                mergeArr[cur] = nums2[n1];
                n1++;
            }
            cur++;
        }
        for (int i = 0; i < mergeArr.length; i++) {
            nums1[i] = mergeArr[i];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int cur = nums1.length - 1, m1 = m - 1, n1 = n - 1;
        while (n1 >= 0 || m1 >= 0) {
            if (n1 == -1) {
                nums1[cur] = nums1[m1];
                m1--;
            } else if (m1 == -1) {
                nums1[cur] = nums2[n1];
                n1--;
            } else if (nums1[m1] >= nums2[n1]) {
                nums1[cur] = nums1[m1];
                m1--;
            } else {
                nums1[cur] = nums2[n1];
                n1--;
            }
            cur--;
        }
    }
}
