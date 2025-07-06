package com.lalitbodana.lld.ds.practice;

import java.util.Arrays;

public class RobHouse {
    
    private int[] memo;
    
    public static void main(String[] args) {
        RobHouse rh = new RobHouse();
        System.out.println(rh.robDp(new int[]{1, 2, 3, 1}));
        System.out.println(rh.robDp(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rh.robDp(new int[]{2, 1, 1, 2}));
        
        
    }
    
    public int robDp(int[] nums) {
        int N = nums.length;
        
        // Special handling for empty array case.
        if (N == 0) {
            return 0;
        }
        
        int[] maxRobbedAmount = new int[nums.length + 1];
        
        // Base case initializations.
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N - 1] = nums[N - 1];
        
        // DP table calculations.
        for (int i = N - 2; i >= 0; --i) {
            // Same as the recursive solution.
            maxRobbedAmount[i] = Math.max(
                    maxRobbedAmount[i + 1],
                    maxRobbedAmount[i + 2] + nums[i]
            );
        }
        
        return maxRobbedAmount[0];
    }
    
    public int rob(int[] nums) {
        this.memo = new int[100];
        Arrays.fill(this.memo, -1);
        
        return this.robFrom(0, nums);
    }
    
    private int robFrom(int i, int[] nums) {
        
        if (i >= nums.length) {
            return 0;
        }
        if (this.memo[i] > -1) {
            return this.memo[i];
        }
        
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);
        
        this.memo[i] = ans;
        return ans;
    }
    
    
}
