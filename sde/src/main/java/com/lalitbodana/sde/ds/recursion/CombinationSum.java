package com.lalitbodana.sde.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, target);

    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();
        helper(candidates, 0, target, ans, combin);
        for (List<Integer> i : ans)
            System.out.println(i);
        return ans;
    }

    public static void helper(int[] candidates, int idx, int target, List<List<Integer>> list, List<Integer> combin) {
        if (target == 0) {
            list.add(new ArrayList<>(combin));
            return;
        }
        if (idx == candidates.length || target < 0)
            return;

        combin.add(candidates[idx]);
        helper(candidates, idx, target - candidates[idx], list, combin);
        combin.remove(combin.size() - 1);
        helper(candidates, idx + 1, target, list, combin);

    }
}
