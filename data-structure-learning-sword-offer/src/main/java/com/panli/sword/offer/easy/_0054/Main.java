package com.panli.sword.offer.easy._0054;

import com.panli.sword.offer.domain.TreeNode;

/**
 * 二叉搜索树的第k大节点，二叉搜索树又称二叉排序树，左节点值 < 根节点值 < 右节点值
 *
 * 先序遍历二叉树：根左右
 * 中序遍历二叉树：左根右
 * 后续遍历二叉树：左右根
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    private int k;
    private int result;

    public int kthLargest(TreeNode root, int k) {
        if(root == null){
            throw new RuntimeException("TreeNode is empty.");
        }
        this.k = k;
        inOrderTree(root);
        return result;
    }

    /**
     * 中序遍历二叉搜索树：左根右，节点值：左 < 根 < 右，故借助中序遍历逆向输出节点值会得到：右 > 根 > 左
     *
     * @param root
     */
    public void inOrderTree(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTree(root.right);
        if(--this.k == 0){
            this.result = root.val;
            return;
        }
        inOrderTree(root.left);
    }
}
