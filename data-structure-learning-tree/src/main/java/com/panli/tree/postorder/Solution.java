package com.panli.tree.postorder;

import com.panli.tree.domain.TreeNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2021-04-13
 */
public class Solution {


    /**
     * 二叉树的后序递归遍历
     *
     * @param root
     */
    public static void postOrderTreeRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTreeRecur(root.left);
        postOrderTreeRecur(root.right);
        System.out.println(root.val);
    }

    /**
     * 二叉树的后序非递归遍历
     *
     * @param root
     */
    public static void postOrderTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }
}
