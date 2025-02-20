package com.lalitbodana.lld.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        helper(arr, 0, new ArrayList<>());
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
