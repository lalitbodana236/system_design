package com.lalitbodana.sde.ds.heap;

import java.util.ArrayList;
import java.util.List;

class MinHeap {
    
    private List<Integer> heap;
    
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        
        minHeap.initializeHeap();              // null
        minHeap.insert(4);                     // null
        minHeap.insert(1);                     // null
        minHeap.insert(10);                    // null
        System.out.println(minHeap.getMin());  // 1
        System.out.println(minHeap.heapSize()); // 3
        System.out.println(minHeap.isEmpty() ? 1 : 0); // 0
        minHeap.extractMin();                  // null
        minHeap.changeKey(0, 16);              // null
        System.out.println(minHeap.getMin());  // 10
    }
    
    public void initializeHeap() {
        heap = new ArrayList<>();
    }
    
    public void insert(int key) {
        heap.add(key);
        heapifyUp(heap.size() - 1);
    }
    
    public void extractMin() {
        if (heap.isEmpty()) return;
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        heapifyDown(0);
    }
    
    public int getMin() {
        if (heap.isEmpty()) return -1;
        return heap.get(0);
    }
    
    public int heapSize() {
        return heap.size();
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    public void changeKey(int index, int newVal) {
        if (index < 0 || index >= heap.size()) return;
        
        int oldVal = heap.get(index);
        heap.set(index, newVal);
        
        if (newVal < oldVal) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }
    
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) < heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }
    
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int smallest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            
            if (left < size && heap.get(left) < heap.get(smallest))
                smallest = left;
            if (right < size && heap.get(right) < heap.get(smallest))
                smallest = right;
            
            if (smallest != index) {
                swap(smallest, index);
                index = smallest;
            } else break;
        }
    }
    
    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}

