package com.panli.sword.offer.easy._0024;

import com.panli.sword.offer.domain.ListNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2021-04-05
 */
public class Solution {

    /**
     * 借助栈解决
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode pHead = new ListNode(0);
        ListNode curNode = pHead;
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.pop());
            curNode.next = node;
            curNode = node;
        }
        return pHead.next;
    }

    /**
     * 原地反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
