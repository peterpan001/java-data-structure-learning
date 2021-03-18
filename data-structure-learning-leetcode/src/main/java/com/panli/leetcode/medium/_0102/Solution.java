package com.panli.leetcode.medium._0102;

import com.panli.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    /**
     * 二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        // 如果根节点为空，直接返回
        if (root == null) {
            return lists;
        }
        // 声明队列，利用队列先进先出特性
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 根节点进队列
        queue.add(root);
        // 队列不为空，则一直循环
        while (!queue.isEmpty()) {
            // 获取当前层次的元素个数
            int size = queue.size();
            // 声明指标，用于分割当前层次队列节点
            int cur = 0;
            List<Integer> list = new ArrayList<Integer>();
            // 当前层次节点出队列，退出条件的当前层次队列所有节点已经出队列了
            while (cur < size) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                cur++;
            }
            lists.add(list);
        }
        return lists;
    }
}
