package com.panli.interview.合并两个有序链表;

/**
 * 合并两个有序链表
 *
 * @author lipan
 * @date 2021-03-29
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) { // 如果l1为空，直接返回l2
            return l2;
        }
        if (l2 == null) { // 如果l2为空，直接返回l1
            return l1;
        }
        ListNode head = new ListNode(0); // 声明合并链表的头节点
        ListNode curNode = head; // 声明指向头节点指针
        while (l1 != null && l2 != null) { // 合并有序链表
            if (l1.val >= l2.val) {
                curNode.next = l2;
                l2 = l2.next;
            } else {
                curNode.next = l1;
                l1 = l1.next;
            }
            curNode = curNode.next;
        }
        if (l1 != null) { // l1不为空，直接指向l1
            curNode.next = l1;
        }
        if (l2 != null) { // l2不为空，直接指向l2
            curNode.next = l2;
        }
        return head.next;
    }
}
