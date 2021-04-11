package com.panli.sword.offer.easy._0055_II;

import com.panli.sword.offer.domain.TreeNode;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depTree(root.left) - depTree(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }


    private int depTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depTree(node.left), depTree(node.right)) + 1;
    }


}
