package com.lalitbodana.lld.tuf.twopointer;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSumOpt(nums, goal));
    }
    
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                } else if (sum > goal) break;
            }
        }
        
        return count;
    }
    
    public static int numSubarraysWithSumOpt(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            
            count += right - left + 1;
        }
        
        return count;
    }
    
    public static int numSubarraysWithSum2(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            
            // check if there's a prefix sum = sum - goal
            count += map.getOrDefault(sum - goal, 0);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
    
}
