package com.panli.tree.depth;

import com.panli.tree.domain.TreeNode;

/**
 * @author lipan
 * @date 2021-04-13
 */
public class Solution {

    /**
     * 二叉树递归求深度：最大深度
     *
     * @param root
     * @return
     */
    public int treeDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepthRecur(root.left);
        int rightDepth = treeDepthRecur(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
