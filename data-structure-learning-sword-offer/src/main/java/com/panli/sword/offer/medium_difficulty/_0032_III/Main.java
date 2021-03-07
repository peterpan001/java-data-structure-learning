package com.panli.sword.offer.medium_difficulty._0032_III;

import com.panli.sword.offer.domain.TreeNode;

import java.util.*;

/**
 * @author lipan
 * @date 2020-09-01
 * @desc 从上到下打印二叉树-III
 */
public class Main {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) { // 临界条件，如果根节点为空直接返回
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // 声明队列进行层次遍历
        List<List<Integer>> list = new ArrayList<List<Integer>>(); //声明list存储结果值
        queue.add(root); // 根节点进队列
        int idx = 1; // 是否反转子队列指针，树的深度
        while (!queue.isEmpty()) { // 终止条件：队列为空
            int size = queue.size(); // 获取当前层次队列大小
            List<Integer> subList = new ArrayList<Integer>(); // 存储层次元素的子list
            for (int i = 0; i < size; i++) { // 将当前层次的元素放入子list中，并让其孩子节点进队列
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (idx % 2 == 0) { // 深度能被2整除，子list需要反转
                Collections.reverse(subList);
            }
            idx++; // 树的深度+1
            list.add(subList); // 将子list放入父list中
        }
        return list;
    }
}
