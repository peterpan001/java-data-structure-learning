package com.panli.interview.平衡二叉树;

import com.panli.interview.domain.TreeNode;

/**
 * 平衡二叉树
 *
 * @author lipan
 * @date 2021-04-06
 */
public class Solution {

    /**
     * 平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depTree(root.left) - depTree(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depTree(node.left), depTree(node.right)) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDep = depTree(root.left);
        int rightDep = depTree(root.right);
        if (Math.abs(leftDep - rightDep) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

}
