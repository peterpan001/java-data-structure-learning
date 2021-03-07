package com.panli.sword.offer.medium_difficulty._0032_I;

import com.panli.sword.offer.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lipan
 * @date 2020-08-31
 * @desc 从上到下打印二叉树 I
 */
public class Main {

    /**
     * 从上到下打印二叉树，即层次遍历二叉树，又称广度优先搜索算法(BFS)
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) { // 临界值判断，如果为空，直接返回
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // 借助队列实现层次遍历
        List<Integer> list = new ArrayList<Integer>(); // 存层次遍历的元素
        queue.add(root); // 根节点入队列
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // 队头节点出栈
            list.add(node.val); // 放入list集合中
            if (node.left != null) { // 如果左节点孩子不为空，则进入队列
                queue.add(node.left);
            }
            if (node.right != null) { // 如果右节点孩子不为空，则进入队列
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()]; // 声明数组
        for (int i = 0; i < res.length; i++) { // 将list集合元素放入数组
            res[i] = list.get(i);
        }
        return res; //返回
    }
}
