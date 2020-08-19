package com.panli.linked.circle;

import com.panli.linked.domain.LinkedNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lipan
 * @date 2020-08-19
 * @desc 判断结点是否形成环
 */
public class Main {

    public static void main(String[] args) {

    }

    // 判断结点是否形成了环：借助快慢指针
    public static boolean isCircleNode(LinkedNode pHead) {
        if (pHead == null) {
            return false;
        }
        LinkedNode slowNode = pHead; // 慢指针
        LinkedNode quickNode = pHead; // 快指针
        while (slowNode.next != null) { // 如果慢结点指针下一个结点为空则直接返回
            if (quickNode.next.next == null) { // 如果快指针结点为空则直接返回
                return false;
            }
            quickNode = quickNode.next.next; // 快指针走两步
            if (slowNode == quickNode) { // 结点相等则有环
                return true;
            }
            slowNode = slowNode.next; // 慢指针走一步
        }
        return false;
    }

    // 找到两个链表中的第一个公共结点。
    public static LinkedNode findCommonNode(LinkedNode pHead1, LinkedNode pHead2) {
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    // 找到两个链表中的第一个公共结点，借助两个队列，即可实现，或者借助于两个栈也可以(队列：先进先出;栈：先进后出)
    public static LinkedNode findCommonNodeByQueue(LinkedNode pHead1, LinkedNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Queue<LinkedNode> queue1 = new LinkedList<LinkedNode>();
        Queue<LinkedNode> queue2 = new LinkedList<LinkedNode>();
        while (pHead1 != null) {
            queue1.offer(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            queue2.offer(pHead2);
            pHead2 = pHead2.next;
        }
        while (!queue1.isEmpty()) {
            LinkedNode cur1 = queue1.poll();
            LinkedNode cur2 = queue2.poll();
            if (cur1 == cur2) {
                return cur1;
            }
        }
        return null;
    }

}
