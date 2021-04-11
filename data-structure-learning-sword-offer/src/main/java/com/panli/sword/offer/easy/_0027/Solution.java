package com.panli.sword.offer.easy._0027;

import com.panli.sword.offer.domain.TreeNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmpNode = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmpNode);
        return root;
    }

    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            TreeNode tmpNode = node.left;
            node.left = node.right;
            node.right = tmpNode;
        }
        return root;
    }
}
