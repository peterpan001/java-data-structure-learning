package com.panli.leetcode.medium._0019;

import com.panli.leetcode.domain.ListNode;

/**
 * @author lipan
 * @date 2021-04-09
 */
public class Solution {

    /**
     * 删除链表的倒数第 N 个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead = new ListNode(0, head);
        int len = getLength(head);
        ListNode tmpNode = pHead;
        for (int i = 0; i < len - n; i++) {
            tmpNode = tmpNode.next;
        }
        tmpNode.next = tmpNode.next.next;
        return pHead.next;
    }

    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
