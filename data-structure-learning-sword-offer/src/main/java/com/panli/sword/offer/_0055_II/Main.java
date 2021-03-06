package com.panli.sword.offer._0055_II;

import com.panli.sword.offer.domain.TreeNode;

/**
 * 平衡二叉树
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {


    /**
     * 1. 判断 当前二叉树 的 左子树和右子树是否 高度相差1以内（<2）
     * 2. 判断 当前二叉树 的 左子树和右子树是否 平衡
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dfsTree(root.left, 1) - dfsTree(root.right, 1)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfsTree(TreeNode treeNode, int curDepth) {
        if (treeNode == null) {
            return curDepth;
        }
        curDepth++;
        return Math.max(dfsTree(treeNode.left, curDepth), dfsTree(treeNode.right, curDepth));
    }
}
