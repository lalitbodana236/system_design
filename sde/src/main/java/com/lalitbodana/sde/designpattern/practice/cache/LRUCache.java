package com.lalitbodana.sde.designpattern.practice.cache;

import com.lalitbodana.sde.lld.cache.dto.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> map ;
    Node head;
    Node tail;
    
    int capacity;
    
    public LRUCache(int size) {
        this.capacity = size;
        map=new HashMap<>();
        
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertToHead(node); // move to most recently used
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // update
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertToHead(node);
        } else {
            if (map.size() == capacity) {
                // evict least recently used
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertToHead(newNode);
            map.put(key, newNode);
        }
    }
    
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insertToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
