package com.panli.stack.queue;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-17
 * @desc 借助于两个栈模拟对列
 * 栈：先进后出；队列：先进先出
 */
public class StackToQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 栈实现元素进队列
    public void add(int item) {
        if (stack1.isEmpty() && stack2.isEmpty()) { // 如果栈都为空，选择stack1入栈
            stack1.push(item);
            return;
        }

        //判断哪个栈不为空，就一直向其压入元素
        if (stack1.isEmpty()) {
            stack2.push(item);
        }
        if (stack2.isEmpty()) {
            stack1.push(item);
        }
    }

    // 栈实现元素出队列
    public int poll() {
        if (stack1.isEmpty() && stack2.isEmpty()) { //如果两个栈都为空，则返回-1
            return -1;
        }

        // 判断哪个栈不为空，就将其n-1个元素压入另一个栈，最后一个元素直接出栈即可
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
