package com.panli.linked.find;

import com.panli.linked.domain.LinkedNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipan
 * @date 2020-08-18
 * @desc 查找链表节点
 */
public class Main {
    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(0);
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        node.next = node1;
        node1.next = node2;
        node2.next = null;
        LinkedNode midNode = findMidNode(node);
        System.out.println(midNode.data);
    }

    // 借助快慢链表查找倒数第k个节点
    public static LinkedNode findCountDownKNode(LinkedNode pHead, int k) {
        if (pHead == null || k < 0) { // 参数校验
            return null;
        }
        // 声明快慢指针，都指向头节点
        LinkedNode preNode = pHead;
        LinkedNode lastNode = pHead;

        // 先让快节点 preNode 走 k-1 步
        for (int i = 1; i < k; i++) {
            if (preNode.next != null) {
                preNode = preNode.next;
            } else {
                return null;
            }
        }

        // 循环遍历到 preNode 节点结束位置，即为倒数第k个节点
        while (preNode.next != null) {
            preNode = preNode.next;
            lastNode = lastNode.next;
        }
        return lastNode;
    }

    // 将节点元素存储在一个有序数组里面，然后从数组中获取
    public static LinkedNode findCountDownKNodeByList(LinkedNode pHead, int k) {
        if (pHead == null || k < 0) {
            return null;
        }
        List<LinkedNode> list = new ArrayList<LinkedNode>();
        while (pHead != null) {
            list.add(pHead);
            pHead = pHead.next;
        }
        return list.get(list.size() - k);
    }

    public static LinkedNode findMidNode(LinkedNode pHead) {
        if (pHead == null) {
            return null;
        }
        LinkedNode slowNode = pHead; // 慢指针
        LinkedNode quickNode = pHead; // 快指针
        while (slowNode.next != null) {
            if (quickNode.next.next == null) {
                return slowNode; //处理只有两个结点的情况
            }
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
        }
        return slowNode;
    }
}
