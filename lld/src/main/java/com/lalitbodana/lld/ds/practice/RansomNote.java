package com.lalitbodana.lld.ds.practice;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        // Count required characters from ransomNote
        for (char c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Decrease count only if the character is required
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        
        // Check if any character is still needed
        for (int count : map.values()) {
            if (count > 0) return false;
        }
        
        return true;
    }
    
    
    public boolean canConstructOpt(String ransomNote, String magazine) {
        int[] freq = new int[26];
        
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            if (--freq[c - 'a'] < 0) return false;
        }
        
        return true;
    }
    
}
