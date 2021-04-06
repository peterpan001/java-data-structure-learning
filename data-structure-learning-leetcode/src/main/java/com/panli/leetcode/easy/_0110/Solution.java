package com.panli.leetcode.easy._0110;

import com.panli.leetcode.domain.TreeNode;

/**
 * 平衡二叉树
 *
 * @author lipan
 * @date 2021-04-06
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDep = depthTree(root.left);
        int rightDep = depthTree(root.right);
        if (Math.abs(leftDep - rightDep) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depthTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depthTree(node.left), depthTree(node.right)) + 1;
    }
}
