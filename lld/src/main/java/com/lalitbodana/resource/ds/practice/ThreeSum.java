package com.lalitbodana.resource.ds.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ThreeSum {
    
    static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
    
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    if (!ans.contains(Arrays.asList(nums[i], nums[j], nums[k])))
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                
                k++;
            }
        }
        
        return ans;
    }
}
