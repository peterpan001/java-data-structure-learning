package com.panli.sword.offer.easy._0009;

import java.util.Stack;

/**
 * 栈模拟队列
 *
 * @author lipan
 * @date 2021-04-04
 */
public class StackQueue {
    Stack<Integer> popStack;
    Stack<Integer> pushStack;

    public StackQueue() {
        popStack = new Stack<Integer>();
        pushStack = new Stack<Integer>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (popStack.isEmpty()) {
            while (pushStack.size() > 0) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.isEmpty() ? -1 : popStack.pop();
    }
}
