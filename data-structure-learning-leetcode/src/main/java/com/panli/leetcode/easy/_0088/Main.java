package com.panli.leetcode.easy._0088;

/**
 * 合并两个有序数组
 *
 * @author lipan
 * @date 2021-03-14
 */
public class Main {


    /**
     * 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            int tmpNum = nums2[i - m];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums1[j] > tmpNum) {
                    nums1[j + 1] = nums1[j];
                } else {
                    break;
                }
            }
            nums1[j + 1] = tmpNum;
        }
    }

    /**
     * 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int copyArr[] = copyArr(nums1, m);
        int idxNums1 = 0;
        int idxNums2 = 0;
        while (idxNums1 < m && idxNums2 < n) {
            if (copyArr[idxNums1] > nums2[idxNums2]) {
                nums1[idxNums1 + idxNums2] = nums2[idxNums2];
                idxNums2++;
            } else {
                nums1[idxNums1 + idxNums2] = copyArr[idxNums1];
                idxNums1++;
            }
        }
        while (idxNums1 < m) {
            nums1[idxNums1 + idxNums2] = copyArr[idxNums1];
            idxNums1++;
        }
        while (idxNums2 < n) {
            nums1[idxNums1 + idxNums2] = nums2[idxNums2];
            idxNums2++;
        }
    }

    private int[] copyArr(int nums[], int m) {
        int copyArr[] = new int[m];
        for (int i = 0; i < m; i++) {
            copyArr[i] = nums[i];
        }
        return copyArr;
    }
}
