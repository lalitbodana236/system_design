package com.lalitbodana.resource.tuf.twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinctOpt1(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(subarraysWithKDistinctOpt1(new int[]{1, 2, 1, 3, 4}, 3));
    }
    
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                seen.add(nums[j]);
                if (seen.size() == k)
                    count++;
                else if (seen.size() > k)
                    break;
            }
        }
        return count;
    }
    
    public static int subarraysWithKDistinctOpt1(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    private static int atMostK(int[] nums, int k) {
        if (k == 0) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            while (freq.size() > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) freq.remove(nums[left]);
                left++;
            }
            
            count += right - left + 1;
        }
        
        return count;
    }
    
}
