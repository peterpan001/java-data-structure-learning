package com.panli.sword.offer._0019;

/**
 * @author lipan
 * @date 2020-08-26
 * @desc 正则表达式匹配
 */
public class Main {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) { // 在p为空后，只需要看s是否为空即可；是：匹配，否则不匹配
            return s.isEmpty();
        }
        // 查看首元素是否一致
        boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //如果下一个元素是*，两种情况，1：从s串开头重新匹配；2：从s串第二位开始匹配，相当于p的第一个字符因为有*可以无限多个
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        } else { // 比较s的第二个字符与p的第二个字符
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}