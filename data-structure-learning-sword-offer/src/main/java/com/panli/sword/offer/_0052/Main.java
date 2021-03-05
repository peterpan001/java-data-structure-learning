package com.panli.sword.offer._0052;

import com.panli.sword.offer.domain.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表的第一个公共节点
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {


    /**
     * 借助集合set解决，将其中一个节点开始的链表放入set集合，遍历另一个链表，判断此节点是否包含在set集合中即可
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while (headA != null) {
            nodeSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodeSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 先遍历两个链表，得到两个链表长度，使其中一个较长的链表遍历到和较短链表一样的长度，一起向后遍历并判断节点是否相同
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        long aLen = getListNodeLength(headA);
        long bLen = getListNodeLength(headB);
        while (aLen != bLen) {
            if (aLen > bLen) {
                headA = headA.next;
                aLen--;
            } else {
                headB = headB.next;
                bLen--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public long getListNodeLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    /**
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

}
