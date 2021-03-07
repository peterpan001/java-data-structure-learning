package com.panli.sword.offer.medium_difficulty._0035;

import com.panli.sword.offer.domain.RandomNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * @date 2020-09-02
 * @desc 复杂链表的复制
 */
public class Main {


    /**
     * 复制复杂链表：借助hashMap结构
     *
     * @param head
     * @return
     */
    public RandomNode copyRandomList_1(RandomNode head) {
        Map<RandomNode, RandomNode> map = new HashMap<RandomNode, RandomNode>(); // 声明HashMap
        RandomNode cur = head;
        // 复制复杂链表节点的值
        while (cur != null) {
            // 复制复杂链表的值
            map.put(cur, new RandomNode(cur.val));
            // 移动指针到下一个节点
            cur = cur.next;
        }
        // 复制复杂链表节点的指针
        cur = head;
        while (cur != null) {
            // 复制复杂链表的next指针
            map.get(cur).next = map.get(cur.next);
            // 复制复杂链表的random指针
            map.get(cur).random = map.get(cur.random);
            // 移动指针到下一个节点
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 复制复杂链表：将当前节点拷贝复制到下一个节点
     *
     * @param head
     * @return
     */
    public RandomNode copyRandomList_2(RandomNode head) {
        if (head == null) { // 临界值判断
            return null;
        }

        RandomNode curr = head; // 声明指针指向头节点

        // 复制节点值及next指针，并且每个节点的copy节点都跟在当前节点的后面
        while (curr != null) {
            RandomNode next = curr.next; // 保存下一个next节点
            RandomNode copyNode = new RandomNode(curr.val); // 复制当前节点
            curr.next = copyNode; // 当前节点next指针指向复制节点
            copyNode.next = next; // 复制节点next指针指向next节点
            curr = next; // 当前节点指向next节点，继续下一个节点copy
        }

        // 复制节点的random指针
        curr = head;
        while (curr != null) {
            RandomNode next = curr.next.next; // 保存原链表的next节点(curr.next.next是因为curr.next为当前节点的copy，curr.next.next才为真正的下一个节点// )
            RandomNode copyCurr = curr.next; // 取出当前链表的copy节点
            copyCurr.random = curr.random != null ? curr.random.next : null; // copy节点random指针赋值
            curr = next; // 当前节点指向next节点，继续下一次节点random指针copy
        }

        // 拆分链表
        curr = head; // 原链表的头节点
        RandomNode resNode = curr.next; // copy链表的头节点
        while (curr != null) {
            RandomNode next = curr.next.next; // 保存原链表的下一个节点next，新链表的next的next节点
            RandomNode copyCurr = curr.next; // 拷贝节点
            curr.next = next; // 将原链表当前节点的next指向原链表的next节点，即由指向copyCurr指向copyCurr.next
            copyCurr.next = next != null ? next.next : null; // copy节点的next指向copy链表的next节点
            curr = next; // 当前节点指向next节点，继续下一次循环
        }
        return resNode;
    }
}
