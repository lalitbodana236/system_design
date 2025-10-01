package com.lalitbodana.sde.ds.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReplaceElementsByItsRankInTheArray {
    
    public static void main(String[] args) {
        
        for (int i : rank(new int[]{20, 15, 26, 2, 98, 6}))
            System.out.print(i + " ");
        
        System.out.println();
        
        for (int i : rank(new int[]{1, 5, 8, 15, 8, 25, 9}))
            System.out.print(i + " ");
        
        System.out.println();
    }
    
    public static int[] rank(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            minHeap.add(i);
        }
        
        int rank = 1;
        while (!minHeap.isEmpty()) {
            int val = minHeap.poll();
            if (!map.containsKey(val)) {
                map.put(val, rank++);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        
        return arr;
    }
}
