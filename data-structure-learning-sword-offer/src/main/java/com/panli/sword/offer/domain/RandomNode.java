package com.panli.sword.offer.domain;

/**
 * @author lipan
 * @date 2020-09-02
 */
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
