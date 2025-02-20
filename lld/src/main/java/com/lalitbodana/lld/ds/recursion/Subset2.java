package com.lalitbodana.lld.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> ans = subset2(arr);
        for (List<Integer> i : ans)
            System.out.println(i);
    }

    public static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>()); // Start with an empty subset
        Arrays.sort(arr); // Sorting ensures duplicates are adjacent

        int prevSize = 0; // Tracks the start index of new subsets for duplicates

        for (int i = 0; i < arr.length; i++) {
            int size = ans.size();

            // If the current element is a duplicate, only use subsets added in the last iteration
            int startIndex = (i > 0 && arr[i] == arr[i - 1]) ? prevSize : 0;
            prevSize = ans.size(); // Update prevSize for the next duplicate check

            for (int j = startIndex; j < size; j++) {
                List<Integer> subset = new ArrayList<>(ans.get(j));
                subset.add(arr[i]);
                ans.add(subset);
            }
        }
        return ans;
    }

    public static List<List<Integer>> subset2(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr); // Sort the array to handle duplicates
        //backtrack(arr, 0, ans, new ArrayList<>());
        helper(arr, 0, ans, new ArrayList<>());
        return ans;
    }

    private static void backtrack(int[] arr, int index, List<List<Integer>> ans, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue; // Skip duplicates

            temp.add(arr[i]);
            backtrack(arr, i + 1, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private static void helper(int[] arr, int index, List<List<Integer>> ans, List<Integer> temp) {
        if (index == arr.length) {
            // System.out.println(ans);
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[index]);
        helper(arr, index + 1, ans, temp);
        temp.remove(temp.size() - 1);
        int idx = index + 1;
        while (idx < arr.length && arr[idx] == arr[idx - 1])
            idx++;

        helper(arr, idx, ans, temp);
    }
}
