package com.panli.sword.offer.domain;

/**
 * @author lipan
 * @date 2020-09-03
 */
public class BidirectionalNode {
    public int val;
    public BidirectionalNode left;
    public BidirectionalNode right;

    public BidirectionalNode() {
    }

    public BidirectionalNode(int _val) {
        val = _val;
    }

    public BidirectionalNode(int _val, BidirectionalNode _left, BidirectionalNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
