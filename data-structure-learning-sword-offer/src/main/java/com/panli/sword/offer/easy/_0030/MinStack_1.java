package com.panli.sword.offer.easy._0030;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 包含min函数的栈
 */
public class MinStack_1 {

    private Stack<Integer> stack; // 声明栈存储当前栈元素
    private int min = Integer.MAX_VALUE; // 声明变量存储当前最小值，注意Integer与int类型的隐士转换

    /**
     * initialize your data structure here.
     */
    public MinStack_1() {
        stack = new Stack<Integer>(); // 初始化
    }

    public void push(int x) { // 进栈，需要和全局最小进行比较，大于最小值直接进栈，否则将当前最小值进栈，更换当前最小值，并将x进栈，此举措是为了保证在当前最小值的后面紧跟栈里次最小值，这样当最小值出栈后，可以再次快速找到最小值
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() { // 出栈，如果当前出栈元素为栈里最小值，则再弹出一个元素即为当前栈里的最小值
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() { // 栈顶元素
        return stack.peek();
    }

    public int min() { // 最小值
        return min;
    }
}
