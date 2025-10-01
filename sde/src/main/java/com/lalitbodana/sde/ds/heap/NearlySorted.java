package com.lalitbodana.sde.ds.heap;

import java.util.PriorityQueue;

public class NearlySorted {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        nearlySorted(arr, 3);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
    
    public static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (Integer i : arr) {
            minHeap.add(i);
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
        }
    }
    
    public static void nearlySortedOpt1(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int i = 0;
        for (; i <= k && i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        
        int index = 0;
        
        for (; i < arr.length; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
