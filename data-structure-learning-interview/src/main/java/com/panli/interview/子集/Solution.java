package com.panli.interview.子集;

import java.util.ArrayList;
import java.util.List;

/**
 * 从一个大小为N的集合中取出任意元素，输出所有唯一的组合。
 * 如 [a,b,c] 可组合为 []、[a]、[b]、[c]、[ab]、[bc]、[ac]、[abc]。
 * <p>
 * 要求如下：
 * 组合内的元素数大于等于 0 小于等于 数组大小；
 * 组合内不能有重复元素，如 [aab] 是不符合要求的组合；
 * 组合内元素的位置随意，即 [ab] 和 [ba] 视为同一种组合；
 *
 * @author lipan
 * @date 2021-03-18
 */
public class Solution {

    public static void main(String[] args) {
        String[] strArr = new String[]{"a", "b", "c"};
        List<String> list = getAllCombination(strArr);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> getAllCombination(String[] strArr) {
        List<String> list = new ArrayList<String>();
        list.add("[]");
        if (strArr == null) {
            return list;
        }
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < strArr.length; j++) {
                sb.append(strArr[i]);
                if (i == j) {
                    list.add("[" + sb.toString() + "]");
                }
                for (int z = j + 1; z < strArr.length; z++) {
                    sb.append(strArr[z]);
                    list.add("[" + sb.toString() + "]");
                }
                sb.setLength(0);
            }
        }
        return list;
    }
}
