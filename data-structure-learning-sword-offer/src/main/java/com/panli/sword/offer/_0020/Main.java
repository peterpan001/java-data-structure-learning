package com.panli.sword.offer._0020;

/**
 * @author lipan
 * @date 2020-08-27
 * @desc 表示数值的字符串
 */
public class Main {

    /**
     * 正则表达式
     * <p>
     * [\\+\\-]?：正或负符号出现与否
     * \\d*：整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?：如果出现小数点，那么小数点后面必须有数字；否则一起不出现
     * ([eE][\\+\\-]?\\d+)?：如果存在指数部分，那么e或E肯定出现，+或-可以不出现，紧接着必须跟着整数；或者整个部分都不出现
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        return s.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    /**
     * 借助Java API
     *
     * @param s
     * @return
     */
    public boolean isNumber_2(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 根据规律进行判断
     *
     * @param s
     * @return
     */
    public boolean isNumber_3(String s) {
        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < s.length(); i++) {
            // e的情况：1. e后面一定要接数字；2. 不能同时存在两个e
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (i == s.length() - 1) {
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                sign = true;
            } else if (s.charAt(i) == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
