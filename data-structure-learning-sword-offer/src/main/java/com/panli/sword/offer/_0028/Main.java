package com.panli.sword.offer._0028;

import com.panli.sword.offer.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * @date 2020-08-29
 * @desc 对称的二叉树
 */
public class Main {

    /**
     * 借助递归判断二叉树是否对称
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_1(TreeNode root) {
        if (root == null) { //如果树为空直接返回true
            return true;
        }
        return isSymmetricTree(root.left, root.right); // 递归遍历左右节点
    }

    /**
     * 递归遍历左右节点判断是否为对称二叉树
     *
     * @param left
     * @param right
     * @return
     */
    private boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) { // 如果左节点与右节点同时为空，说明遍历完毕，则为对称二叉树
            return true;
        }
        if (left == null || right == null || left.val != right.val) { // 如果左/右/左值!=右值，则不对称
            return false;
        }
        // 递归的遍历判断左节点的左孩子和右节点的右孩子：isSymmetricTree(left.left, right.right)
        // 递归的遍历判断左节点的有孩子和右节点的左孩子：isSymmetricTree(left.right, right.left)
        return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
    }

    /**
     * 非递归遍历实现二叉树是否对称判断
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_2(TreeNode root) {
        if (root == null) { // 如果树为空直接返回true
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // 声明队列存储二叉树
        queue.add(root.left); // 左孩子进队列
        queue.add(root.right); // 右孩子进队列 两两进队列
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll(); // 左孩子出队列
            TreeNode right = queue.poll(); // 右孩子出队列  两两出队列
            if (left == null && right == null) { // 如果左右为空则继续循环队列
                continue;
            }
            if (left != null || right != null || left.val != right.val) { // 如果左/右/左值!=右值，则不对称
                return false;
            }
            // 左右孩子进队列需要注意，对称二叉树性质，需要孩子的对称的节点一块进队列，则上面才能一块出队列进行循环判断
            queue.add(left.left); //左左/右右对称
            queue.add(right.right);
            queue.add(left.right); // 左右/右左对称
            queue.add(right.left);
        }
        return true;
    }
}
