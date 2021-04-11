package com.panli.sword.offer.medium_difficulty._0049;

/**
 * 丑数
 *
 * @author lipan
 * @date 2021-03-07
 */
public class Main {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int uglyArr[] = new int[n + 1];
        uglyArr[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int nums2 = uglyArr[p2] * 2, nums3 = uglyArr[p3] * 3, nums5 = uglyArr[p5] * 5;
            uglyArr[i] = Math.min(Math.min(nums2, nums3), nums5);
            if (uglyArr[i] == nums2) {
                p2++;
            }
            if (uglyArr[i] == nums3) {
                p3++;
            }
            if (uglyArr[i] == nums5) {
                p5++;
            }
        }
        return uglyArr[n];
    }
}
