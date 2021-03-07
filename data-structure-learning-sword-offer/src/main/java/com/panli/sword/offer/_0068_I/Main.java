package com.panli.sword.offer._0068_I;

import com.panli.sword.offer.domain.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {
    /**
     * 二叉搜索树，又称二叉排序树，即左子树节点值小于根节点值，右子树节点值大于根节点值
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) { //如果有任意一节点位空，直接返回null
            return null;
        }
        while (root != null) {
            if (root.val > p.val && root.val > q.val) { //根节点值大于p、q节点值，说明在公共祖先在根节点左侧
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) { //根节点值小于p、q节点值，说明在公共祖先在根节点左侧
                root = root.right;
            } else { //根节点值即为最近的公共祖先
                return root;
            }
        }
        return null;
    }
}
