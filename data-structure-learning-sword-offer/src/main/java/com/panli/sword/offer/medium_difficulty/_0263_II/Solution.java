package com.panli.sword.offer.medium_difficulty._0263_II;

/**
 * 丑数
 *
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {

    public int nthUglyNumber(int n) {
        int uglyNums[] = new int[n + 1];
        uglyNums[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int nums2 = uglyNums[p2] * 2, nums3 = uglyNums[p3] * 3, nums5 = uglyNums[p5] * 5;
            uglyNums[i] = Math.min(Math.min(nums2, nums3), nums5);
            if (uglyNums[i] == nums2) {
                p2++;
            }
            if (uglyNums[i] == nums3) {
                p3++;
            }
            if (uglyNums[i] == nums5) {
                p5++;
            }
        }
        return uglyNums[n];
    }
}
