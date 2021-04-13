package com.panli.tree.inorder;

import com.panli.tree.domain.TreeNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2021-04-13
 */
public class Solution {

    /**
     * 二叉树的中序递归遍历
     *
     * @param root
     */
    public static void inOrderTreeRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTreeRecur(root.left);
        System.out.println(root.val);
        inOrderTreeRecur(root.right);
    }

    /**
     * 二叉树的中序非递归遍历
     *
     * @param root
     */
    public static void inOrderTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }
}
