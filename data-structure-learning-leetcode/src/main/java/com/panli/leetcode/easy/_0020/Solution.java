package com.panli.leetcode.easy._0020;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    public boolean isValid_1(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
            if (s.contains("[]")) {
                s = s.replace("[]", "");
            }
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
        }
        return s.length() == 0;
    }

    /**
     * 有效括号借助栈解决
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // 字符串长度不为2的整数倍，直接返回，括号两两匹配
        if (s.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
