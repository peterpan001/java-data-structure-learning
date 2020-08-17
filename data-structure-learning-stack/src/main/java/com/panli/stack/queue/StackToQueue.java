package com.panli.stack.queue;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 借助于两个栈模拟对列
 */
public class StackToQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 栈实现元素进队列
    public void add(int item) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            stack1.push(item);
            return;
        }
        if (stack1.isEmpty()) {
            stack2.push(item);
        }
        if (stack2.isEmpty()) {
            stack1.push(item);
        }
    }

    // 栈实现元素出队列
    public int poll() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (stack1.isEmpty()) {
            while (stack2.size() > 1) {
                stack1.push(stack2.pop());
            }
            return stack2.pop();
        }
        if (stack2.isEmpty()) {
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }
        return -1;
    }

}
