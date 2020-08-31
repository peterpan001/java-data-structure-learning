package com.panli.sword.offer._0031;

import java.util.Stack;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 栈的压入、弹出序列
 */
public class Main {

    /**
     * 栈的压入、弹出序列
     * 首先将pushed元素进栈，在不为空的情况下，模拟popped元素出栈，如果可以栈元素全部为空，则证明popped可以作为pushed元素的出栈顺序
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>(); // 声明栈，将pushed元素进栈
        int idx = 0; // 索引，指向popped元素的位置
        for (int val : pushed) { // 将pushed元素出栈
            stack.push(val);
            while (!stack.isEmpty() && stack.peek() == popped[idx]) { // 不为空时，栈顶元素与popped元素进栈比较,如果相同，则出栈，继续下一次比较，直到栈为空或者元素不相等
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty(); // 结束时判断栈元素是否为空，是则popped为pushed的出栈顺序
    }
}
