package com.panli.sword.offer._0009;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-21
 * @desc 用两个栈实现队列
 */
public class CQueue {

    public Stack<Integer> stackPop;
    public Stack<Integer> stackPush;

    public CQueue() {
        stackPop = new Stack<Integer>();
        stackPush = new Stack<Integer>();
    }

    // 进队列
    public void appendTail(int value) { // 元素进队列
        stackPush.push(value);
    }

    // 出队列
    public int deleteHead() { // 元素出队列
        if (stackPop.isEmpty()) { // 如果出队列的栈元素为空，则将stackPush的元素全部压入stackPop栈
            while (stackPush.size() > 0) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.isEmpty() ? -1 : stackPop.pop(); // stackPop不为空，直接弹出元素，否则返回-1
    }
}
