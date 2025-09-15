package com.lalitbodana.sde.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//    int target = 7;
//        for(List<Integer> l :combinationSum(candidates,target)) {
//            System.out.println(l);
//        }
        
       int[] dcandidates = {10,1,2,7,6,1,5};
        int dtarget = 8;
        for(List<Integer> l :combinationSumDuplicate(dcandidates,dtarget)) {
            System.out.println(l);
        }
    }
    
    public static List<List<Integer>> combinationSumDuplicate(int[] candidates, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        Arrays.sort(candidates);
        helperD(candidates,target,0,sums,new ArrayList<>());
        return sums;
    }
    
    private static void helperD(int[] candidates, int target, int idx, List<List<Integer>> sums, List<Integer> temp) {
        if(target==0){
            sums.add( new ArrayList<>(temp));
            return;
        }
        
       
        
        for(int i=idx;i<candidates.length;i++){
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target)
                break;
                temp.add(candidates[i]);
            helperD(candidates,target-candidates[i],i+1,sums,temp);
            temp.removeLast();
            
        }
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sums = new ArrayList<>();
            helper(candidates,target,0,sums,new ArrayList<>());
        return sums;
    }
    
    private static void helper(int[] candidates, int target, int idx, List<List<Integer>> sums, List<Integer> temp) {
        if(target==0){
            sums.add( new ArrayList<>(temp));
            return;
        }
        
        if(target<0) return;
        
        for(int i=idx;i<candidates.length;i++){
            temp.add(candidates[i]);
            helper(candidates,target-candidates[i],i,sums,temp);
            temp.removeLast();
          
        }
    }
}
