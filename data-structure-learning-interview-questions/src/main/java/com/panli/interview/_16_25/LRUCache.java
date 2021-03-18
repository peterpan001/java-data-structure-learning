package com.panli.interview._16_25;

import java.util.LinkedHashMap;

/**
 * LRU 缓存
 *
 * @author lipan
 * @date 2021-03-18
 */
public class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Integer val = map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        }
        map.put(key, value);
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
