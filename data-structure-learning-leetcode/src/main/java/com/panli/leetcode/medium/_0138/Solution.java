package com.panli.leetcode.medium._0138;

import com.panli.leetcode.domain.Node;

import java.util.HashMap;

/**
 * 复制带随机指针的链表
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    /**
     * 复制带随机指针的链表
     *
     * 第一遍复制节点的val ，next 和 random 暂时为空，并将源节点和克隆节点形成映射存放在一个 HashMap 中
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> hashMap = new HashMap<Node, Node>();
        Node pHead = head;
        while (pHead != null) {
            hashMap.put(pHead, new Node(pHead.val));
            pHead = pHead.next;
        }
        pHead = head;
        while (pHead != null){
            hashMap.get(pHead).next = hashMap.get(pHead.next);
            hashMap.get(pHead).random = hashMap.get(pHead.random);
            pHead = pHead.next;
        }
        return hashMap.get(head);
    }
}
