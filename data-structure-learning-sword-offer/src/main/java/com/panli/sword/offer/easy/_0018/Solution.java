package com.panli.sword.offer.easy._0018;

import com.panli.sword.offer.domain.ListNode;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pHead = head;
        while (pHead.next != null) {
            if (pHead.next.val == val) {
                pHead.next = pHead.next.next;
            } else {
                pHead = pHead.next;
            }
        }
        return head;
    }
}
