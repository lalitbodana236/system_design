package com.lalitbodana.lld.ds.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("BANC".equals(minWindowArray(s, t)));
        System.out.println("a".equals(minWindowArray("a", "a")));
        System.out.println("".equals(minWindowArray("a", "aa")));
        System.out.println("ab".equals(minWindowArray("bdab", "ab")));
    }
    
    public static String minWindowArray(String s, String t) {
        int[] need = new int[128];
        
        // Step 1: Fill frequency map with characters of t
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int count = t.length();
        
        // Step 2: Expand the window
        while (right < s.length()) {
            char c = s.charAt(right);
            
            if (need[c] > 0) {
                count--;
            }
            need[c]--;
            right++;
            
            // Step 3: Shrink the window from the left
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                
                char leftChar = s.charAt(left);
                need[leftChar]++;
                if (need[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }
        
        // Step 4: Return result
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        
    }
    
    public static String minWindowBruteForce(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        String result = "";
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                // System.out.println(sub);
                if (containsAllChars(sub, t)) {
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;
    }
    
    private static boolean containsAllChars(String s, String t) {
        int[] sCount = new int[128];
        int[] tCount = new int[128];
        
        for (char c : s.toCharArray()) sCount[c]++;
        for (char c : t.toCharArray()) tCount[c]++;
        
        for (int i = 0; i < 128; i++) {
            if (tCount[i] > sCount[i]) return false;
        }
        return true;
    }
    
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        int required = targetFreq.size();
        int formed = 0;
        
        Map<Character, Integer> windowFreq = new HashMap<>();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            
            if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
                formed++;
            }
            
            // Try to shrink the window
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }
                
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < targetFreq.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
    
    
}
