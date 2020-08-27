package com.panli.sword.offer._0024;

import com.panli.sword.offer.domain.ListNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-27
 * @desc 反转链表
 */
public class Main {

    /**
     * 反转链表：遍历链表的每一个节点，并修改该节点的next指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList_1(ListNode head) {
        if (head == null || head.next == null) { // 临界值判断，为空或只有一个节点的链表直接返回
            return head;
        }
        ListNode pHead = null; // 声明新链表的头节点
        while (head != null) {
            ListNode tmpNode = head.next; // 存储原链表的下一个节点信息
            head.next = pHead; // 断开原链表的next指针，即原链表的节点成为新链表的头节点
            pHead = head; // 移动新链表的pHead指针，使其指向新链表的头节点
            head = tmpNode; // 将节点指向下一个节点，重新进行相同的操作，直至到原链表的末尾
        }
        return pHead;
    }

    /**
     * 反转链表：借助栈的先进后出特性实现
     *
     * @param head
     * @return
     */
    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) { // 临界值判断，为空或只有一个节点的链表直接返回
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>(); // 声明栈
        while (head != null) { // 链表所有节点进栈
            stack.push(head);
            head = head.next;
        }
        ListNode pHead = new ListNode(0); // 声明新链表的头节点
        ListNode curNode = pHead; // 声明移动指针指向头节点
        while (!stack.empty()) {
            ListNode tmpNode = stack.pop(); // 弹出链表的第一个节点
            tmpNode.next = null; // 将其next指针指向null
            curNode.next = tmpNode; // 新链表的头节点指向弹出节点元素
            curNode = tmpNode; // 新链表的头节点指针移动下一个节点位置，即新链表末尾
        }
        return pHead.next; // 返回即可
    }
}
