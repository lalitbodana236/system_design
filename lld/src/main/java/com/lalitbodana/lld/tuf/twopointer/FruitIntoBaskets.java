package com.lalitbodana.lld.tuf.twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
        System.out.println(totalFruit(fruits));
    }
    
    public static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        for (int i = 0; i < fruits.length; i++) {
            Set<Integer> busket = new HashSet<>();
            for (int j = i; j < fruits.length; j++) {
                busket.add(fruits[j]);
                if (busket.size() > 2) {
                    break;
                }
                
                maxFruits = Math.max(maxFruits, j - i + 1);
            }
        }
        
        return maxFruits;
    }
    
    public static int totalFruitOpt1(int[] fruits) {
        int maxFruits = 0;
        int left = 0;
        int right = 0;
        int k = 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > k) {
                map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        
        return maxFruits;
    }
    
    public static int totalFruitOpt2(int[] fruits) {
        int maxFruits = 0;
        int left = 0;
        int right = 0;
        int k = 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            
            if (map.size() > k) {
                map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        
        return maxFruits;
    }
}
