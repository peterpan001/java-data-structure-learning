package com.panli.leetcode.medium._0082;

import com.panli.leetcode.domain.ListNode;

/**
 * 删除排序链表中的重复元素 II
 *
 * @author lipan
 * @date 2021-03-31
 */
public class Solution {

    public ListNode deleteDuplicatesMedium(ListNode head) {
        // 如果头节点为空或者链表只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 声明一个元素的新节点链表尾节点指向链表
        ListNode pHead = new ListNode(0, head);
        ListNode cur = pHead; // 声明指针链表
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) { // 如果相等就覆盖移除
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else { // 否则继续下一个
                cur = cur.next;
            }
        }
        return pHead.next; // 返回新链表的下一个节点即可
    }
}
