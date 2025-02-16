package com.lalitbodana.lld.ds.recursion.subsequence;

import java.util.ArrayList;
import java.util.List;

public class Pemutation {

    public static void main(String[] args) {

        List<List<Integer>> permutations = generate(new int[]{1, 2, 3}, new ArrayList<>());
        for (List<Integer> p : permutations)
            System.out.println(p);

        List<List<Integer>> permutationsOptimised = permute(new int[]{1, 2, 3});
        for (List<Integer> p : permutationsOptimised)
            System.out.println(p);
    }

    public static List<List<Integer>> generate(int[] arr, List<Integer> list) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (arr.length == 0) {
            //System.out.println(list);
            permutations.add(new ArrayList<>(list)); // Store the generated permutation
            return permutations;
        }

        for (int i = 0; i < arr.length; i++) {
            int ans = arr[i];

            // Creating new array excluding the current element
            int[] newArr = new int[arr.length - 1];
            int index = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    newArr[index++] = arr[j];
                }
            }

            // Creating a new list to maintain state
            List<Integer> newList = new ArrayList<>(list);
            newList.add(ans);

            permutations.addAll(generate(newArr, newList));
        }

        return permutations;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // Optimized tracking
        generatePermutations(nums, new ArrayList<>(), used, result);
        return result;
    }

    private static void generatePermutations(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);

                generatePermutations(nums, current, used, result);

                // Backtrack
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}
