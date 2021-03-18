package com.panli.leetcode.medium._0144;

import com.panli.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root); // 根进栈
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop(); // 根出栈
            list.add(node.val);
            if (node.right != null) { // 右节点进栈
                stack.push(node.right);
            }
            if (node.left != null) { // 左节点进栈
                stack.push(node.left);
            }
        }
        return list;
    }
}
