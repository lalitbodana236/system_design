package com.lalitbodana.sde.ds;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int[][] arr = {{1,4},{4,2},{6,5},{2,7},{3,11}};
        
        
        int[] nums = {1,4,2,6,5,2,7,3,11};
        Arrays.sort(nums);
        Arrays.sort(arr,(o1, o2) -> o2[0]-o1[0]);
       for(int[] i : arr){
           System.out.println(i[0]+ " "+i[1]);
       }
       
       List<Integer> list = new ArrayList<>();
        
        Map<Integer,Integer> map  = new TreeMap();
        map.put(1,2);
        map.put(2,4);
        map.put(3,5);
        map.put(4,6);
        map.put(5,2);
        
        Map<Integer, Integer> sortedByValue = map.entrySet()
                                                      .stream()
                                                      .sorted(Map.Entry.comparingByValue()) // ascending order
                                                      .collect(Collectors.toMap(
                                                              Map.Entry::getKey,
                                                              Map.Entry::getValue,
                                                              (e1, e2) -> e1,
                                                              LinkedHashMap::new)); // preserve order
        
        System.out.println("Sorted by Value: " + sortedByValue.keySet());
        
        List<Integer> list2  = Arrays.asList(1,2);
        
        for(int i=0;i<list2.size();i++){
            int j = list2.get(i);
            list2.set(i,j+1);
        }
        
        System.out.println(list2);
        
        
     }
}
