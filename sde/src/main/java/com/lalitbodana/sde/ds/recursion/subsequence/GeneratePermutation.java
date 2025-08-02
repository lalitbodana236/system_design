package com.lalitbodana.sde.ds.recursion.subsequence;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutation {
    public static void main(String[] args) {

        generate("abc", "");
    }

    public static void generate(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            generate(newStr, ans + ch);
        }


    }

    public static void backtrack(String str, String ans, boolean[] visited) {
        if (ans.length() == str.length()) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(str, ans + str.charAt(i), visited);
                visited[i] = false; // Backtrack
            }
        }
    }

    public static void permute(int[] arr, int idx, List<List<Integer>> ans) {
        if (idx == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : arr) temp.add(num);
            ans.add(temp); // Store a new copy to avoid modification issues
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            permute(arr, idx + 1, ans);
            swap(arr, idx, i); // Backtrack
        }
    }

    public static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
