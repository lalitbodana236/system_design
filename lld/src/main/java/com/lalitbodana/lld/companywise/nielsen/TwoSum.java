package com.lalitbodana.lld.companywise.nielsen;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, -1);
        System.out.println(1 - map.getOrDefault(5, 1));
    }
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
            
        }
        
        return new int[0];
    }
}
