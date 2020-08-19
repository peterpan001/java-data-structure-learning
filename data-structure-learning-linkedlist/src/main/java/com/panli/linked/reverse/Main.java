package com.panli.linked.reverse;

import com.panli.linked.domain.LinkedNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-18
 * @desc 逆序链表节点
 */
public class Main {

    public static void main(String[] args) {
        // 构造链表：3->2->1->0
        LinkedNode node = new LinkedNode(0);
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        // 逆序打印
        reversePrintLinkedNode(node);
    }

    // 逆序打印输出链表，利用栈先进后出特性可以实现逆序打印
    public static void reversePrintLinkedNode(LinkedNode pHead) {
        if (pHead == null) { // 如果链表为空直接输出
            return;
        }
        Stack<Integer> stack = new Stack<Integer>(); //声明栈
        while (pHead != null) { // 将链表元素一个一个进栈
            stack.push(pHead.data);
            pHead = pHead.next;
        }
        while (!stack.isEmpty()) { // 将栈元素弹出，实现逆序打印
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // 原地逆置链表
    public static LinkedNode reverseLinkedNode(LinkedNode pHead) {
        if (pHead == null) {
            return null;
        }
        LinkedNode reverse = null; // 声明新链表头结点指针，最初指向空
        LinkedNode next = null; // 用来备份当前操作结点的下一个结点的地址
        while (pHead != null) {
            next = pHead.next; // 备份pHead的下一个结点的地址
            pHead.next = reverse; // 将pHead指向的结点与新链表的头结点连接结点
            reverse = pHead; // 将reverse指向新链表的头结点，赋值为pHead
            pHead = next; // 将pHead指向当前原链表的头结点
        }
        return reverse;
    }

    // 头插法实现链表逆置
    public static LinkedNode reverseLinkedNodeNew(LinkedNode pHead) {
        if (pHead == null) {
            return null;
        }
        LinkedNode tmp = new LinkedNode(0, null); // 设置临时头结点
        LinkedNode next = null; // 用来备份当前操作结点的下一个结点的地址
        while (pHead != null) {
            next = pHead.next; // 备份 pHead 的下一个结点的地址
            pHead.next = tmp.next; //指向临时头结点tmp的下一个结点
            tmp.next = pHead; // 使临时头结点tmp指向pHead指向的结点
            pHead = next; // 移动 pHead 指针，将其指向next备份的地址
        }
        return tmp.next;
    }
}
