package com.lalitbodana.sde.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        helper(arr, 0, new ArrayList<>());
    }

    public List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int a : arr) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(ans.get(i));
                subset.add(a);
                ans.add(subset);
            }
        }
        return ans;
    }

    public static void helper(int[] arr, int idx, List<Integer> ans) {
        if (idx == arr.length) {
            System.out.println(ans);
            return;
        }
        ans.add(arr[idx]);
        helper(arr, idx + 1, ans);
        ans.remove(ans.size() - 1);
        helper(arr, idx + 1, ans);

    }
}
