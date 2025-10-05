package com.lalitbodana.sde.ds.bitmanipulations;

public class SumOfAllSubsetXORTotal {
    public static void main(String[] args) {
    
    }
    
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }
    
    private int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor; // one subset completed
        }
        // Choice 1: include nums[index]
        int include = dfs(nums, index + 1, currentXor ^ nums[index]);
        // Choice 2: exclude nums[index]
        int exclude = dfs(nums, index + 1, currentXor);
        
        return include + exclude;
    }
    
    public int subsetXORSumOpt1(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int xor = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // if ith element is included
                    xor ^= nums[i];
                }
            }
            total += xor;
        }
        return total;
    }
    
    public int subsetXORSumOpt2(int[] nums) {
        int or = 0;
        for (int x : nums)
            or |= x;
        return or * (1 << (nums.length - 1));
    }
    
}
