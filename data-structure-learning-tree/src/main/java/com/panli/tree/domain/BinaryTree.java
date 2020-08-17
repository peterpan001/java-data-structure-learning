package com.panli.tree.domain;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 二叉树domain类
 */
public class BinaryTree {
    private int data;
    private BinaryTree leftNode;
    private BinaryTree rightNode;

    public void setData(int data) {
        this.data = data;
    }
    public int getData() {
        return this.data;
    }

    public void setLeftNode(BinaryTree leftNode) {
        this.leftNode = leftNode;
    }
    public BinaryTree getLeftNode() {
        return this.leftNode;
    }

    public void setRightNode(BinaryTree rightNode) {
        this.rightNode = rightNode;
    }
    public BinaryTree getRightNode() {
        return this.rightNode;
    }
}
