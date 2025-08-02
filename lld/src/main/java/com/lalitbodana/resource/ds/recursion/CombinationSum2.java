package com.lalitbodana.resource.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinationSum(candidates, target);
        System.out.println();
        int[] candidates1 = {2, 5, 2, 1, 2};
        int target1 = 5;
        combinationSum(candidates1, target1);

    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, ans, new ArrayList<>());
        for (List<Integer> i : ans)
            System.out.println(i);
        return ans;
    }

    private static void helper(int[] candidates, int index, int target, List<List<Integer>> ans, List<Integer> combin) {
        if (target == 0) {
            ans.add(new ArrayList<>(combin));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            // If the current element is greater than target, break (since array is sorted)
            if (candidates[i] > target) break;

            combin.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], ans, combin);
            combin.remove(combin.size() - 1);
        }
    }
}
