package com.panli.leetcode.easy._0530;

import com.panli.leetcode.domain.TreeNode;

/**
 * 二叉搜索树的最小绝对差
 *
 * @author lipan
 * @date 2021-04-13
 */
public class Solution {

    int res = Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(res, root.val - pre);
            pre = root.val;
        }
        inorder(root.right);
    }
}
