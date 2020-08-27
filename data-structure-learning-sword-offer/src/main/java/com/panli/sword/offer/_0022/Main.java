package com.panli.sword.offer._0022;

import com.panli.sword.offer.domain.ListNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-27
 * @desc 链表中倒数第k个节点
 */
public class Main {

    /**
     * 链表中倒数第k个节点，利用快慢指针即可解决此问题，让快指针先走k步，然后慢指针和快指针一起走到末尾，慢指针即为链表中倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd_1(ListNode head, int k) {
        if (head == null || k < 0) { //非空校验
            return head;
        }
        ListNode quickNode = head; // 快指针
        ListNode slowNode = head; // 慢指针
        for (int i = 1; i < k; i++) { // 先走k步
            if (quickNode.next != null) { // 如果在走到k步之前已经到链表末尾，则直接返回空，否则快指针走到k步
                quickNode = quickNode.next;
            } else {
                return null;
            }
        }
        while (quickNode.next != null) { // 快慢指针一起走，到快指针走到末尾，慢指针即指向链表中倒数第k个节点
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    /**
     * 借助于栈解决此问题，让所有元素进栈，然后弹出k个节点元素并组成链表即可得到结果
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd_2(ListNode head, int k) {
        if (head == null || k < 0) { // 临界值判断
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>(); // 声明栈
        while (head != null) { // 所有元素进栈
            stack.push(head);
            head = head.next;
        }
        ListNode pHead = stack.pop(); // 弹出首节点
        while (--k > 0) { // 弹出k-1个节点，并修改节点的next指针组成链表中倒数第k个节点
            ListNode tmpNode = stack.pop();
            tmpNode.next = pHead;
            pHead = tmpNode;
        }
        return pHead;
    }
}
