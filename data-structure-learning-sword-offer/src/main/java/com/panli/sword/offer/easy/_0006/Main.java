package com.panli.sword.offer.easy._0006;

import com.panli.sword.offer.domain.ListNode;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-21
 * @desc 从尾到头打印链表
 */
public class Main {

    /**
     * 借助栈的先进后出特性，遍历链表，并将元素放入栈中，再依次出栈即可实现
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>(); // 声明栈
        while (head != null) { // 遍历链表，并将val放入栈中
            stack.push(head.val);
            head = head.next;
        }
        int[] nums = new int[stack.size()]; // 声明与栈大小一样的数组
        for (int i = 0; i < nums.length; i++) { // 将元素放入数组中即可
            nums[i] = stack.pop();
        }
        return nums; // 返回
    }
}
