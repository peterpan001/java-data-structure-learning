package com.panli.leetcode.easy._0021;

import com.panli.leetcode.domain.ListNode;

/**
 * @author lipan
 * @date 2020-08-20
 * @desc 合并两个有序链表
 * @solution 可以借助于递归实现/声明一个新链表用来存储合并后的有序链表，分别遍历l1与l2将其最小值依次放入新链表中即可
 */
public class Main {

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if (l1 == null) { // 如果l1为空，直接返回l2
            return l2;
        }
        if (l2 == null) { // 如果l2为空，直接返回l1
            return l1;
        }
        ListNode pHead = new ListNode(0); //声明存储合并后链表的头节点
        ListNode mergeNode = pHead; // 指针节点
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                mergeNode.next = l2;
                l2 = l2.next;
            } else {
                mergeNode.next = l1;
                l1 = l1.next;
            }
            mergeNode = mergeNode.next;
        }
        if (l1 == null) {
            mergeNode.next = l2;
        }
        if (l2 == null) {
            mergeNode.next = l1;
        }
        return pHead.next;
    }

    /**
     * 借助于递归实现两个有序链表的合并
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists_2(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists_2(l1.next, l2);
            return l1;
        }
    }
}
