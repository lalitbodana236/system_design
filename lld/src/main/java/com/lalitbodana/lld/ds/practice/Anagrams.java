package com.lalitbodana.lld.ds.practice;

import java.util.*;

public class Anagrams {
    
    
    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        for (ArrayList<Integer> it : a.anagramsOpt(Arrays.asList("cat", "dog", "god", "tca"))) {
            System.out.println(it);
        }
//        for (ArrayList<Integer> it : a.anagrams(Arrays.asList("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"
//        ))) {
//            System.out.println(it);
//        }
    }
    
    public ArrayList<ArrayList<Integer>> anagramsOpt(final List<String> A) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < A.size(); i++) {
            String key = getFrequencyKey(A.get(i));
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(i + 1);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private String getFrequencyKey(String word) {
        int[] freq = new int[26]; // assuming lowercase English letters only
        
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Convert the frequency array to a string key like: "1#0#0#..." to ensure uniqueness
        StringBuilder sb = new StringBuilder();
        for (int f : freq) {
            sb.append(f).append('#');
        }
        System.out.println(sb);
        return sb.toString();
    }
    
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < A.size(); i++) {
            String word = A.get(i);
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(i + 1);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        while (left < word1.length()) {
            char ch1 = word1.charAt(left);
            char ch2 = word2.charAt(left);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
            left++;
        }
        
        for (int i : map.values()) {
            if (i != 0) return false;
        }
        
        return true;
        
    }
}
