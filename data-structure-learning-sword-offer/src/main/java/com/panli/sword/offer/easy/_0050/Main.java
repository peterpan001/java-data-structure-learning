package com.panli.sword.offer.easy._0050;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 *
 * @author lipan
 * @date 2021-02-23
 */
public class Main {

    /**
     * ASCII A-Z：65～90；a-z：97～122
     * <p>
     * 借助数组来解决
     *
     * @param s
     * @return
     */
    public char firstUniqChar_1(String s) {
        if (s == null) {
            throw new RuntimeException("字符串s为空");
        }
        int[] count = new int[128];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c]++;
        }
        for (char c : chars) {
            if (count[c] == 1) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 借助HashMap来解决
     *
     * @param s
     * @return
     */
    public char firstUniquChar_2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : chars) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
