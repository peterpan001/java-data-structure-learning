package com.panli.interview.两个链表的第一个公共节点;

import com.panli.interview.domain.ListNode;

/**
 * @author lipan
 * @date 2021-04-09
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pHeadA = headA, pHeadB = headB;
        while (pHeadA != pHeadB) {
            pHeadA = pHeadA != null ? pHeadA.next : headB;
            pHeadB = pHeadB != null ? pHeadB.next : headA;
        }
        return pHeadA;
    }
}
