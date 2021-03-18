package com.panli.leetcode.easy._0160;

import com.panli.leetcode.domain.ListNode;

/**
 * 相交链表
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {
    /**
     * 消除两个链表的长度差
     * <p>
     * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
     * 如果 pA 到了末尾，则 pA = headB 继续遍历
     * 如果 pB 到了末尾，则 pB = headA 继续遍历
     * 比较长的链表指针指向较短链表head时，长度差就消除了
     * 如此，只需要将最短链表遍历两次即可找到位置
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果 headA 或者 headB 有一个为空直接返回空
        if (headA == null || headB == null) {
            return null;
        }
        // 声明指向 headA 和 headB 的头指针
        ListNode nodeA = headA, nodeB = headB;
        // 遍历链表
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}
