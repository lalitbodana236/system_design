package com.lalitbodana.lld.grind169;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringNaive("abcabcbb"));
        System.out.println(lengthOfLongestSubstringNaive("bbbbb"));
        System.out.println(lengthOfLongestSubstringNaive("pwwkew"));
    }
    
    public static int lengthOfLongestSubstringNaive(String s) {
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[256];
            Arrays.fill(hash, -1);
            for (int j = i; j < s.length(); j++) {
                if (hash[s.charAt(j)] != -1) {
                    break;
                }
                hash[s.charAt(j)] = 1;
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int left = 0;
        int right = 0;
        String str = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            
            if (hash[c] == -1) {
                hash[c] = 1;
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
                
            } else {
                hash[s.charAt(left)] = -1;
                left++;
            }
            
            
        }
        
        
        return maxLength;
    }
}
