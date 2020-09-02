package com.panli.sword.offer.domain;

/**
 * @author lipan
 * @date 2020-09-02
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
