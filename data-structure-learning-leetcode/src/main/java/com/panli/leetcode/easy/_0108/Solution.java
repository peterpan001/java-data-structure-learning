package com.panli.leetcode.easy._0108;

import com.panli.leetcode.domain.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author lipan
 * @date 2021-04-09
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(nums[0]);
        }
        return helper(nums, 0, len - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
