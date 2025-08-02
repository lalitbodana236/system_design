package com.lalitbodana.sde.ds.linkedlist;

public class MyHashMap {

    private static final int SIZE = 1000;

    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[SIZE];
    }

    public int getIndex(int key) {
        return key % SIZE;
    }

    private Node findPrev(int index, int key) {
        if (nodes[index] == null) {
            nodes[index] = new Node(-1, -1); // Dummy node
        }
        Node prev = nodes[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node prev = findPrev(index, key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value; // Update existing key
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        Node prev = findPrev(index, key);
        return (prev.next != null) ? prev.next.value : -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node prev = findPrev(index, key);
        if (prev.next != null) {
            prev.next = prev.next.next; // Remove node
        }
    }
}

class Node {
    int key, value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
