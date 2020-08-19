package com.panli.linked.domain;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 链表 POJO类
 */
public class LinkedNode {
    public int data;
    public LinkedNode next;

    public LinkedNode(int data) {
        this.data = data;
    }

    public LinkedNode(int data, LinkedNode next) {
        this.data = data;
        this.next = next;
    }
}
