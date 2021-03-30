package com.panli.interview.LRU;

import java.util.LinkedHashMap;

/**
 * LRU：缓存机制
 *
 * @author lipan
 * @date 2021-03-30
 */
public class LRUCache {

    private int capacity;
    LinkedHashMap<Integer, Integer> map; // 借助 LinkedHashMap 实现 LRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    /**
     * 如果 key存在，则取出key对应的val
     *
     * @param key
     * @return
     */
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
