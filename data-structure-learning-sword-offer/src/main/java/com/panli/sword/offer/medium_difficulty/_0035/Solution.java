package com.panli.sword.offer.medium_difficulty._0035;

import com.panli.sword.offer.domain.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 复制复杂链表值
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 复制复杂链表节点指针
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
