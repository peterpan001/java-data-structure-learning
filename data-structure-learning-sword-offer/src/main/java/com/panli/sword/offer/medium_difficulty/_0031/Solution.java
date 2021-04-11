package com.panli.sword.offer.medium_difficulty._0031;

import java.util.Stack;

/**
 * @author lipan
 * @date 2021-04-11
 */
public class Solution {


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek().equals(popped[idx])) {
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }
}
