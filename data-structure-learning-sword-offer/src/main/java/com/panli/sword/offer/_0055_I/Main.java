package com.panli.sword.offer._0055_I;

import com.panli.sword.offer.domain.TreeNode;

/**
 * 二叉树的深度
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * 深度遍历思想：一直向 子节点 去遍历 取 左子树 和 右子树 的 最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMaxDepth(root, 0);
    }

    private int getMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        return Math.max(getMaxDepth(root.left, depth), getMaxDepth(root.right, depth));
    }

    public int maxDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth_1(root.left);
        int rightDepth = maxDepth_1(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
