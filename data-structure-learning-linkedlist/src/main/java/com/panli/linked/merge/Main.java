package com.panli.linked.merge;

import com.panli.linked.domain.LinkedNode;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 合并两个单链表
 */
public class Main {

    public static void main(String[] args) {

    }

    // 使用递归实现两个链表合并
    public static LinkedNode mergeTwoLinkedRecur(LinkedNode pHead1, LinkedNode pHead2) {

        // 如果其中一个链表为空，则直接返回另一个链表
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        // 新开辟一个链表用来存储合并后的链表
        LinkedNode pHead;
        if (pHead1.data < pHead2.data) { //如果pHead1的值小，则将pHead1赋值给头节点
            pHead = pHead1;
            pHead.next = mergeTwoLinkedRecur(pHead1.next, pHead2); // 递归遍历
        } else {
            pHead = pHead2; // 否则将pHead2赋值给头节点
            pHead.next = mergeTwoLinkedRecur(pHead1, pHead2.next); // 递归遍历
        }
        return pHead;
    }

    // 使用非递归合并两个链表
    public static LinkedNode mergeTwoLinkedNoRecur(LinkedNode pHead1, LinkedNode pHead2) {
        // 如果其中一个链表为空，则直接返回另一个链表
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        LinkedNode pHead = null;
        if (pHead1.data < pHead2.data) {
            pHead = pHead1;
            pHead1 = pHead1.next;
        } else {
            pHead = pHead2;
            pHead2 = pHead2.next;
        }
        LinkedNode tmp = pHead;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.data < pHead2.data) {
                tmp.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                tmp.next = pHead2;
                pHead2 = pHead2.next;
            }
            tmp = tmp.next;
            tmp.next = null;
        }
        if (pHead1 != null && pHead2 == null) {
            tmp.next = pHead1;
        } else if (pHead1 == null && pHead2 != null) {
            tmp.next = pHead2;
        }
        return pHead;
    }

}
