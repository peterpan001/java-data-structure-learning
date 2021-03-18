package com.panli.leetcode.domain;

/**
 * @author lipan
 * @date 2021-03-18
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
