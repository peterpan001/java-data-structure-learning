package com.panli.leetcode.medium._0019;

import com.panli.leetcode.domain.ListNode;

/**
 * @author lipan
 * @date 2020-08-20
 * @desc 删除链表的倒数第N个节点
 * @solution 借助快慢指针，快指针先走n步，然后快慢指针再一起走，待快指针结束，慢指针的下一个节点就是倒数第n个节点
 * 故令：slowNode = slowNode.next.next即可
 */
public class Main {

    /**
     * 删除链表的倒数第N个节点，借助快慢指针就可以解决
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (n > 0) { // 令快指针先走n步
            fastNode = fastNode.next;
            n--;
        }
        if (fastNode == null) { // 判断删除的是否为第一个节点
            return head.next;
        }
        while (fastNode != null) { // 快慢指针一起走，快指针结束，慢指针就指向倒数第n个节点
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode = slowNode.next.next; // 删除倒数第n个节点
        return head;
    }
}
