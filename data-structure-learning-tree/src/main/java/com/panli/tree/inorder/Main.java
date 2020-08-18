package com.panli.tree.inorder;

import com.panli.tree.domain.BinaryTree;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 中序遍历：左根右
 */
public class Main {
    public static void main(String[] args) {

    }

    // 中序递归遍历二叉树
    public static void inOrderTreeRecur(BinaryTree pRoot) {
        if (pRoot == null) {
            return;
        }
        inOrderTreeRecur(pRoot.getLeftNode()); //左
        System.out.println(pRoot.getData()); //根
        inOrderTreeRecur(pRoot.getRightNode()); //右
    }

    // 中序非递归遍历二叉树
    public static void inOrderTreeNoRecur(BinaryTree pRoot) {
        if (pRoot == null) { //二叉树为空直接返回
            return;
        }
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        BinaryTree cur = pRoot;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur); // 根进栈
                cur = cur.getLeftNode(); // 左节点进栈
            } else {
                cur = stack.pop(); // 左节点出栈
                System.out.println(cur.getData()); // 打印左节点，打印根节点
                cur = cur.getRightNode(); // 处理右节点
            }
        }
    }
}
