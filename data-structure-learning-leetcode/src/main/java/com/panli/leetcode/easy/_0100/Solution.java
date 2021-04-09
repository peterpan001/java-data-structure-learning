package com.panli.leetcode.easy._0100;

import com.panli.leetcode.domain.TreeNode;

/**
 * 相同的树
 *
 * @author lipan
 * @date 2021-04-09
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
