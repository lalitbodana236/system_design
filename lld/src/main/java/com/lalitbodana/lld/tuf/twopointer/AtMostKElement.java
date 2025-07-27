package com.lalitbodana.lld.tuf.twopointer;

import java.util.HashMap;
import java.util.Map;

public class AtMostKElement {
    private static int atMostK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Add current element
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            
            // If it’s the first time seeing this number, reduce k
            if (freq.get(nums[right]) == 1) {
                k--;
            }
            
            // Shrink the window if k < 0
            while (k < 0) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }
            
            // Add all valid subarrays ending at 'right'
            count += right - left + 1;
        }
        
        return count;
    }
    
}
