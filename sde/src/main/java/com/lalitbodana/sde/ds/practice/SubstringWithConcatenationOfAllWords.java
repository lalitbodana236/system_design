package com.lalitbodana.sde.ds.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String[] words = {"aa", "aa"};
        String s = "aaaaaaaaaaaaaa";
        boolean[] visited = new boolean[words.length];
        List<String> ans = new ArrayList<>();
        //backtrack(words, visited, new ArrayList<>(), ans);
        
        System.out.println(findSubstring(s, words));
    }
    
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) return result;
        
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < wordCount) {
                int wordStart = i + j * wordLen;
                String sub = s.substring(wordStart, wordStart + wordLen);
                System.out.println(sub);
                if (!wordMap.containsKey(sub)) break;
                seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                if (seen.get(sub) > wordMap.get(sub)) break;
                j++;
            }
            if (j == wordCount) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private static void backtrack(String[] words, boolean[] visited, List<String> path, List<String> ans) {
        if (path.size() == words.length) {
            System.out.println(String.join("", path));
            ans.add(String.join("", path));
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(words[i]);
                backtrack(words, visited, path, ans);
                path.remove(path.size() - 1); // Backtrack
                visited[i] = false;
            }
        }
    }
    
    public static void permute(String[] word, int idx, String ans) {
        if (word.length == idx) {
            System.out.println(ans);
            return;
        }
        
        
        for (int i = idx; i < word.length; i++) {
            swap(word, idx, i); // Swap to fix the character at current index
            permute(word, idx + 1, ans + word[idx]);
            swap(word, idx, i); // Backtrack to restore original state
        }
        
        
    }
    
    private static void swap(String[] word, int i, int j) {
        String temp = word[i];
        word[i] = word[j];
        word[j] = temp;
    }
}
