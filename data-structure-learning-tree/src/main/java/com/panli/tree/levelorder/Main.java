package com.panli.tree.levelorder;

import com.panli.tree.domain.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 层序遍历
 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * 层序遍历二叉树
     *
     * @param pRoot
     */
    public static void levelOrderTree(BinaryTree pRoot) {
        if (pRoot == null) {
            return;
        }
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            System.out.println(node);
            if (node.getLeftNode() != null) {
                queue.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                queue.add(node.getRightNode());
            }
        }
    }
}