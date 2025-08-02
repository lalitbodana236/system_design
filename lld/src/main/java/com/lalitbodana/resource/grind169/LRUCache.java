package com.lalitbodana.resource.grind169;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final LinkedList<Integer> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        queue.remove((Integer) key);  // Move to back
        queue.addLast(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            queue.remove((Integer) key);
        } else if (queue.size() >= capacity) {
            int lru = queue.pollFirst(); // Remove oldest
            cache.remove(lru);
        }
        queue.addLast(key);
        cache.put(key, value);
    }
}
