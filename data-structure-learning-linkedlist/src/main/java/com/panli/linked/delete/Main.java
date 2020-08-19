package com.panli.linked.delete;

import com.panli.linked.domain.LinkedNode;

/**
 * @author lipan
 * @date 2020-08-18
 * @desc 删除链表节点
 */
public class Main {

    public static void main(String[] args) {

    }

    // 删除链表节点，删除头节点/中间节点/尾节点/只有一个节点
    public static void deleteLinkedNode(LinkedNode pHead, LinkedNode deleteNode) {
        if (pHead == null || deleteNode == null) {
            return;
        }
        if (deleteNode.next != null) { // 要删除的不是尾节点
            deleteNode.data = deleteNode.next.data;
            deleteNode.next = deleteNode.next.next;
        }
        if (pHead == deleteNode) { // 只有一个节点
            pHead = null;
        } else {  //删除的节点是尾节点
            LinkedNode node = pHead;
            while (node.next != deleteNode) { //找到倒数第二个节点
                node = node.next;
            }
            node.next = null; //将倒数第二个节点的next置为空即可
        }
    }

    // 删除奇数位置/偶数位置的单链表
    public static LinkedNode deleteLinkedNode(LinkedNode pHead) {
        LinkedNode oddNode = new LinkedNode(1); // 声明奇数结点链表头
        LinkedNode evenNode = new LinkedNode(2); // 声明偶数结点链表头
        LinkedNode p1 = oddNode; // 声明p1结点指向奇数结点
        LinkedNode p2 = evenNode; // 声明p2结点指向偶数结点
        int i = 1; //索引，辅助判断奇数位置还是偶数位置
        while (pHead != null) {
            if (i % 2 == 1) {
                p1.next = pHead;
                p1 = p1.next;
            }
            if (i % 2 == 0) {
                p2.next = pHead;
                p2 = p2.next;
            }
            pHead = pHead.next;
            i++;
        }
        return oddNode.next; // 返回奇数结点位置
    }
}
