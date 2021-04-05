package com.panli.sword.offer.easy._0003;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * @date 2021-04-04
 */
public class Solution {

    public int findRepeatNumberOriginal(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int val : nums) {
            if (map.containsKey(val)) {
                return val;
            }
            map.put(val, 1);
        }
        return -1;
    }
}
