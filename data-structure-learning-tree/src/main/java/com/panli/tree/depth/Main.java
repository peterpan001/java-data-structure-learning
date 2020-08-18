package com.panli.tree.depth;

import com.panli.tree.domain.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 求解二叉树深度
 */
public class Main {

    public static void main(String[] args) {

    }

    // 二叉树递归求解树的深度
    public static int treeDepthRecur(BinaryTree pRoot) {
        if (pRoot == null) {
            return 0;
        }
        int nLeft = treeDepthRecur(pRoot.getLeftNode());
        int nRight = treeDepthRecur(pRoot.getRightNode());
        return (nLeft > nRight) ? nLeft + 1 : nRight + 1;
    }

    // 二叉树非递归求解树的深度
    public static int treeDepthNoRecur(BinaryTree pRoot) {
        if (pRoot == null) {
            return 0;
        }
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>(); // 设置对列
        queue.offer(pRoot); // 根节点入对列
        int level = 0;
        while (!queue.isEmpty()) {
            int cur = 0; // 当每层遍历完的时候，cur恢复初始值
            int length = queue.size(); // 管控每一次循环遍历完当前层次元素
            while (cur < length) {
                BinaryTree node = queue.poll();
                cur++;
                if (node.getLeftNode() != null) { // 左节点进栈
                    queue.offer(node.getLeftNode());
                }
                if (node.getRightNode() != null) { // 右节点进栈
                    queue.offer(node.getRightNode());
                }
            }
            level++; // 当前层次对列遍历完毕，层次+1
        }
        return level;
    }
}
