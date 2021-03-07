package com.panli.sword.offer.easy._0030;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 包含min函数的栈：每次进栈时，总是将最小值和当前值一块进栈，且最小值在栈顶，空间利用率降低一半
 */
public class MinStack_2 {

    private Stack<Integer> stack; // 声明栈

    public MinStack_2() { // 初始化栈
        stack = new Stack<Integer>();
    }

    public void push(int x) { //元素进栈
        int min = x;
        if (!stack.isEmpty() && stack.peek() < min) { // 寻找最小值
            min = stack.peek();
        }
        stack.push(x); // 元素进栈
        stack.push(min); // 最小值进栈
    }

    public void pop() {
        stack.pop();//最小值出栈
        stack.pop();//当前元素出栈
    }

    public int top() {
        int minNum = stack.pop(); // 栈顶最小元素出栈
        int topNum = stack.peek(); // 获取真实栈顶元素
        stack.push(minNum); // 最小元素进栈
        return topNum; // 返回真实栈顶元素
    }

    public int min() { //栈顶为最小元素
        return stack.peek();
    }
}
