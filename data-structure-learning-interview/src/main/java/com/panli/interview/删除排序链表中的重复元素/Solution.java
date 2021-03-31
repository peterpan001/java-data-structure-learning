package com.panli.interview.删除排序链表中的重复元素;

import com.panli.interview.domain.ListNode;

/**
 * 删除排序链表中的重复元素
 *
 * @author lipan
 * @date 2021-03-31
 */
public class Solution {

    /**
     * 针对于重复元素保留一个
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesEasy(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        while (curNode.next != null) {
            ListNode tmpNode = curNode.next;
            if (tmpNode.val == curNode.val) {
                curNode.next = tmpNode.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }

    /**
     * 针对于重复元素一个不保留
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesMedium(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pHead = new ListNode(0, head);
        ListNode cur = pHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return pHead.next;
    }
}
