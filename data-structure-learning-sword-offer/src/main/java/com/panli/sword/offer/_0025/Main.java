package com.panli.sword.offer._0025;

import com.panli.sword.offer.domain.ListNode;

/**
 * @author lipan
 * @date 2020-08-28
 * @desc 合并两个排序的链表
 */
public class Main {

    /**
     * 合并两个排序的链表：遍历这两个链表，将较小的元素依次放入新链表中即可
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) { // 临界值判断，如果l1为空，直接返回l2
            return l2;
        }
        if (l2 == null) { // 如果l2为空，直接返回l1
            return l1;
        }
        ListNode pHead = new ListNode(0); // 声明新链表的头节点
        ListNode tmpNode = pHead; // 声明新链表的节点指针
        while (l1 != null && l2 != null) { // 依次遍历l1与l2，将其中较小的节点放入新链表中，直到其中一个链表为空
            if (l1.val <= l2.val) {
                tmpNode.next = l1;
                l1 = l1.next;
            } else {
                tmpNode.next = l2;
                l2 = l2.next;
            }
            tmpNode = tmpNode.next;
        }
        if (l1 != null) { // 此时若l2为空，直接将节点指针的next指向l1
            tmpNode.next = l1;
        }
        if (l2 != null) { // 此时若l1为空，直接将节点指针的next指向l2
            tmpNode.next = l2;
        }
        return pHead.next;
    }
}
