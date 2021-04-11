package com.panli.sword.offer.medium_difficulty._0033;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if (len <= 1) {
            return true;
        }
        return verifyPostorder(postorder, 0, len - 1);
    }

    public boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int rootVal = postorder[right];
        int mid = left;
        while (postorder[mid] < rootVal) {
            mid++;
        }
        int tmp = mid;
        while (tmp < right) {
            if (postorder[tmp++] < rootVal) {
                return false;
            }
        }
        return verifyPostorder(postorder, left, mid - 1) && verifyPostorder(postorder, mid, right - 1);
    }
}
