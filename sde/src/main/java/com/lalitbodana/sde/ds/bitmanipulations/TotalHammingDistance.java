package com.lalitbodana.sde.ds.bitmanipulations;

public class TotalHammingDistance {
    
    public int totalHammingDistance(int[] nums) {
        return getTotal(nums,0,0);
    }
    
    public int getTotal(int[] nums, int i,int cur){
        if(i==nums.length){
            return cur;
        }
        
        return getTotal(nums,i+1,cur^nums[i])+getTotal(nums,i+1,cur);
    }
}
