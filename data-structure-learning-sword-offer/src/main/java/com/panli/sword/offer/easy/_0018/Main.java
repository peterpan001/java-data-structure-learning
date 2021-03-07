package com.panli.sword.offer.easy._0018;

import com.panli.sword.offer.domain.ListNode;

/**
 * @author lipan
 * @date 2020-08-26
 * @desc 删除链表的节点
 */
public class Main {

    /**
     * 遍历链表，找到对应的值，删除节点即可
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode_1(ListNode head, int val) {
        if (head == null) { // 链表为空，直接返回null
            return null;
        }
        if (head.val == val) { // 如果为链表头节点，直接返回 head.next 即可
            return head.next;
        }
        ListNode curNode = head;
        while (curNode.next != null) { // 如果在中间或者末尾，则遍历链表，找到对应节点的值使其node.next=node.next.next即可
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next;
                break;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 删除链表的节点；和上面的方法类似，不过上面的删除节点在循环内，这个解法删除节点在循环外
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode_2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode curNode = head;
        while (curNode.next != null && curNode.next.val != val) {
            curNode = curNode.next;
        }
        if (curNode.next != null) {
            curNode.next = curNode.next.next;
        }
        return head;
    }
}
