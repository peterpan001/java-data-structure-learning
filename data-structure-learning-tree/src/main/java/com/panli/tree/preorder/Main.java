package com.panli.tree.preorder;

import com.panli.tree.domain.BinaryTree;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 前序遍历二叉树:根左右
 */
public class Main {

    public static void main(String[] args) {

    }

    // 前序递归遍历二叉树
    public static void preOrderTreeRecursion(BinaryTree pRoot) {
        if (pRoot == null) {
            return;
        }
        System.out.println(pRoot.getData());//根
        preOrderTreeRecursion(pRoot.getLeftNode());//左
        preOrderTreeRecursion(pRoot.getRightNode());//右
    }

    // 前序非递归遍历二叉树，借助于栈，栈：先进后出
    public static void preOrderTreeNoRecursion(BinaryTree pRoot) {
        if (pRoot == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        stack.push(pRoot); // 根节点进栈
        while (!stack.isEmpty()) {
            BinaryTree node = stack.pop(); //出栈
            System.out.println(node.getData());
            if (node.getRightNode() != null) { // 右节点进栈(栈先进后出，故右节点先进栈)
                stack.push(node.getRightNode());
            }
            if (node.getLeftNode() != null) { // 左节点进栈
                stack.push(node.getLeftNode());
            }
        }
    }
}
