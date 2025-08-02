package com.lalitbodana.resource.tuf.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinctOpt1("eceba", 2));
        System.out.println(lengthOfLongestSubstringKDistinctOpt1("aa", 1));
        System.out.println(lengthOfLongestSubstringKDistinctOpt1("a", 1));
        System.out.println(lengthOfLongestSubstringKDistinctOpt1("a", 2));
    }
    
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> seen = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                seen.put(ch, seen.getOrDefault(ch, 0) + 1);
                
                if (seen.size() <= k)
                    maxLength = Math.max(maxLength, j - i + 1);
                else
                    break;
            }
        }
        
        return maxLength;
    }
    
    public static int lengthOfLongestSubstringKDistinctOpt1(String s, int k) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> seen = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            seen.put(ch, seen.getOrDefault(ch, 0) + 1);
            while (seen.size() > k) {
                char leftChar = s.charAt(left);
                seen.put(leftChar, seen.getOrDefault(leftChar, 0) - 1);
                if (seen.get(leftChar) <= 0) seen.remove(leftChar);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
