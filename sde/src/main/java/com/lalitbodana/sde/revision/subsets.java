package com.lalitbodana.sde.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        for(List<Integer> l : subsets(nums)){
            System.out.println(l);
        }
        
        int[] dnums = {1,2,2};
        for(List<Integer> l : subsetsWithDup(dnums)){
            System.out.println(l);
        }
    }
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        Arrays.sort(nums);
        helperDuplicate(nums,subsets,new ArrayList(),0);
        return subsets;
    }
    
    public static void helperDuplicate(int[] nums, List<List<Integer>> subsets, List<Integer> ans, int idx){
        subsets.add(new ArrayList(ans));
        for(int i=idx;i<nums.length;i++){
            if (i > idx && nums[i] == nums[i - 1]) continue;
            ans.add(nums[i]);
            helperDuplicate(nums,subsets,ans,i+1);
            ans.remove(ans.size()-1);
        }
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        helper(nums,subsets,new ArrayList(),0);
        return subsets;
    }
    
    public static void helper(int[] nums, List<List<Integer>> subsets, List<Integer> ans, int idx){
        subsets.add(new ArrayList(ans));
        for(int i=idx;i<nums.length;i++){
            ans.add(nums[i]);
            helper(nums,subsets,ans,i+1);
            ans.remove(ans.size()-1);
        }
    }
}
