package com.panli.leetcode.domain;

/**
 * @author lipan
 * @date 2020-08-20
 * @desc 链表的 POJO 类
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {

    }
}
