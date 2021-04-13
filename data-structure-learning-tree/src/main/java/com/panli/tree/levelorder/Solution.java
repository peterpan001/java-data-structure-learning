package com.panli.tree.levelorder;

import com.panli.tree.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * @date 2021-04-13
 */
public class Solution {

    /**
     * 二叉树的层次遍历
     *
     * @param root
     */
    public void levelOrderTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
}
