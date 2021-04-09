package com.panli.leetcode.easy._0112;

import com.panli.leetcode.domain.TreeNode;

/**
 * 路径总和
 *
 * @author lipan
 * @date 2021-04-09
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
