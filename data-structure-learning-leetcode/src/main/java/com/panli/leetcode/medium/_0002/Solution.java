package com.panli.leetcode.medium._0002;

import com.panli.leetcode.domain.ListNode;

/**
 * @author lipan
 * @date 2020-08-20
 * @desc 两数相加
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) { //如果l1链表为空，直接返回l2
            return l2;
        }
        if (l2 == null) { // 如果l2链表为空，直接返回l1
            return l1;
        }
        ListNode head = null, tail = null; // 声明合并链表的头节点和尾节点
        int carry = 0; // 记录进位值
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0; // 如果l1不为空，取l1值，否则取0
            int v2 = l2 != null ? l2.val : 0; // 如果l2不为空，取l2值，否则取0
            int sum = v1 + v2 + carry; // 计算
            if (head == null) { // 头节点为空
                head = tail = new ListNode(sum % 10); // 当前节点值
            } else { // 头节点不为空
                tail.next = new ListNode(sum % 10);  // 当前节点值
                tail = tail.next;
            }
            carry = sum / 10;  //  记录进位值
            if (l1 != null) { // 移动下一位
                l1 = l1.next;
            }
            if (l2 != null) {  // 移动下一位
                l2 = l2.next;
            }
        }
        if(carry > 0){ // 链表结束，如果进位不为 0
            tail.next = new ListNode(carry);
        }
        return head; // 返回
    }
}
