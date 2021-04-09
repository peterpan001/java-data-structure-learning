package com.panli.leetcode.easy._0104;

import com.panli.leetcode.domain.TreeNode;

/**
 * 二叉树的最大深度
 *
 * @author lipan
 * @date 2021-04-09
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
