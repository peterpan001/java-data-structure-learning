package com.panli.leetcode._0083;

import com.panli.leetcode.domain.ListNode;

/**
 * @author lipan
 * @date 2020-08-20
 * @desc 删除排序链表中的重复元素
 * @solution 直接法：直接遍历链表，如果链表后面节点的值等于此节点的值，让此节点的next指向此节点的next的next
 */
public class Main {
    public static void main(String[] args) {

    }

    // 直接法：遍历链表，如果链表后面节点的值等于此节点的值，让此节点的next指向此节点的next的next
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pHead = head;
        while (pHead != null && pHead.next != null) {
            if (pHead.val == pHead.next.val) {
                pHead.next = pHead.next.next;
            } else {
                pHead = pHead.next;
            }
        }
        return head;
    }


}
