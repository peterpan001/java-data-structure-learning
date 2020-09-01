package com.panli.sword.offer._0032_II;

import com.panli.sword.offer.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lipan
 * @date 2020-08-31
 * @desc 从到下打印二叉树 II
 */
public class Main {

    /**
     * 广度优先搜索，又称层次搜索
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) { // 临界值判断，为空直接返回空集合
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // 声明队列，实现层次遍历
        List<List<Integer>> list = new ArrayList<List<Integer>>(); // 声明list集合，构造返回结果值
        queue.add(root); // 根节点进队列
        while (!queue.isEmpty()) { // 终止条件队列为空
            int size = queue.size(); // 获取当前队列大小，使其一层节点全部出队
            List<Integer> subList = new ArrayList<Integer>(); // 声明子list存储当前层次节点元素
            for (int i = 0; i < size; i++) { // 当前层次队列节点出队列
                TreeNode node = queue.poll();
                subList.add(node.val); // 元素放入子list中
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(subList); // 层次结束，当前子集合放入list集合中
        }
        return list; // 返回
    }
}
