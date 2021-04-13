package com.panli.tree.preorder;

import com.panli.tree.domain.TreeNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2021-04-13
 */
public class Solution {

    /**
     * 二叉树的前序递归遍历
     *
     * @param root
     */
    public static void preOrderTreeRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTreeRecur(root.left);
        preOrderTreeRecur(root.right);
    }


    /**
     * 二叉树的前序非递归遍历
     *
     * @param root
     */
    public static void preOrderTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
