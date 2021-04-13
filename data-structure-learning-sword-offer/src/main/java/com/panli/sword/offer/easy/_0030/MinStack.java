package com.panli.sword.offer.easy._0030;

import java.util.Stack;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class MinStack {
    Stack<Integer> stackA, stackB;

    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.add(x);
        if (stackB.isEmpty() || stackB.peek() >= x) {
            stackB.add(x);
        }
    }

    public void pop() {
        if (stackA.pop().equals(stackB.peek())) {
            stackB.pop();
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}
