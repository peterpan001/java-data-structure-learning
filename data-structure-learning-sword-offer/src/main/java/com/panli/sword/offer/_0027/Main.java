package com.panli.sword.offer._0027;

import com.panli.sword.offer.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-28
 * @desc 二叉树的镜像
 */
public class Main {

    /**
     * 借助层序遍历实现二叉树的镜像：BFS算法
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree_1(TreeNode root) {
        if (root == null) { // 临界值的判断，如果二叉树为空，直接返回
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // 声明队列存储二叉树
        queue.add(root); // root节点进入队列
        while (!queue.isEmpty()) { // 队列不为空，一直循环
            TreeNode node = queue.poll(); // 队列节点出队列
            TreeNode left = node.left; // 进行树的左右节点交换
            node.left = node.right;
            node.right = left;
            if (node.left != null) { // 节点左孩子不为空进队列
                queue.add(node.left);
            }
            if (node.right != null) { // 节点右孩子不为空进队列
                queue.add(node.right);
            }
        }
        return root;
    }

    /**
     * 借助DFS遍历实现二叉树的镜像：DFS算法
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree_2(TreeNode root) {
        if (root == null) { // 临界值的判断，如果二叉树为空，直接返回
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>(); // 声明栈存储二叉树
        stack.push(root); // root节点进入队列
        while (!stack.isEmpty()) { // 队列不为空，一直循环
            TreeNode node = stack.pop(); // 栈节点出队列
            TreeNode left = node.left; // 进行树的左右节点交换
            node.left = node.right;
            node.right = left;
            if (node.left != null) { // 节点左孩子不为空进栈
                stack.push(node.left);
            }
            if (node.right != null) { // 节点右孩子不为空进栈
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 借助非递归中序遍历实现二叉树的镜像
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree_3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                node = node.left;//此处应该为node=node.right，但是因为左右节点已经交换，故此处为node=node.left
            }
        }
        return root;
    }

    /**
     * 借助非递归前序遍历实现二叉树的镜像
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree_4(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}
