package com.lalitbodana.resource.ds.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    
    public static void main(String[] args) {
        int[] arr = {8, 1, 2, 2, 3};
        smallerNumbersThanCurrentOpt(arr);
    }
    
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] smaller = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && nums[i] > nums[j]) {
                    count++;
                }
                
            }
            smaller[i] = count;
        }
        
        return smaller;
    }
    
    public static int[] smallerNumbersThanCurrentOpt(int[] nums) {
        int n = nums.length;
        int[] smaller = Arrays.copyOf(nums, n);
        Arrays.sort(smaller);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(smaller[i], i);
        }
        
        System.out.println(map);
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]);
        }
        
        return res;
    }
}
