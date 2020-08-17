package com.panli.tree.postorder;

import com.panli.tree.domain.BinaryTree;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 后序遍历：左右根
 */
public class Main {
    public static void main(String[] args) {

    }

    // 后序递归遍历二叉树
    public static void postOrderTreeRecursion(BinaryTree pRoot) {
        if (pRoot == null) {
            return;
        }
        postOrderTreeRecursion(pRoot.getLeftNode()); // 左
        postOrderTreeRecursion(pRoot.getRightNode()); // 右
        System.out.println(pRoot.getData()); // 根
    }

    // 后序非递归遍历二叉树，借助于两个栈实现
    public static void postOrderTreeNoRecursion(BinaryTree pRoot) {
        if (pRoot == null) {
            return;
        }
        Stack<BinaryTree> stack1 = new Stack<BinaryTree>();
        Stack<BinaryTree> stack2 = new Stack<BinaryTree>();
        stack1.push(pRoot);
        while (!stack1.isEmpty()) {
            BinaryTree node = stack1.pop(); //根
            stack2.push(node);
            if (node.getRightNode() != null) { // 右
                stack1.push(node.getRightNode());
            }
            if (node.getLeftNode() != null) { // 左
                stack1.push(node.getLeftNode());
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().getData());
        }
    }
}
