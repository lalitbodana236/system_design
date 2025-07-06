package com.lalitbodana.lld.ds.practice;

import java.util.*;

public class PalindromePairs {
    
    Map<String, Boolean> palindromMap = new HashMap<>();
    
    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        PalindromePairs p = new PalindromePairs();
        p.palindromePairsOpt(words);
    }
    
    public List<List<Integer>> palindromePairsOpt(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }
        System.out.println(wordMap);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                System.out.println(left + " " + right);
                // Case 1: If left is palindrome, check reversed(right) in map
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (wordMap.containsKey(reversedRight) && wordMap.get(reversedRight) != i) {
                        ans.add(Arrays.asList(wordMap.get(reversedRight), i));
                    }
                }
                
                // Case 2: If right is palindrome, check reversed(left) in map
                // Avoid duplicates when j == word.length() (right is empty, already covered)
                if (j != word.length() && isPalindrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (wordMap.containsKey(reversedLeft) && wordMap.get(reversedLeft) != i) {
                        ans.add(Arrays.asList(i, wordMap.get(reversedLeft)));
                    }
                }
            }
        }
        
        return ans;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && isPalindrome(words[i] + words[j])) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    System.out.println(words[i] + words[j]);
                    ans.add(pair);
                }
            }
        }
        
        return ans;
    }
    
    public boolean isPalindrome(String word) {
        if (this.palindromMap.containsKey(word)) {
            return palindromMap.get(word);
        }
        
        if (word.length() == 0) {
            palindromMap.put(word, true);
            return true;
        }
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                palindromMap.put(word, false);
                return false;
            }
            left++;
            right--;
        }
        palindromMap.put(word, true);
        return true;
    }
    
}
