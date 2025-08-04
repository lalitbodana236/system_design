package com.lalitbodana.sde.companywise.oracle;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s1 : strs) {
            char[] s = s1.toCharArray();
            Arrays.sort(s);
            String val = new String(s);
            List<String> group = map.getOrDefault(val, new ArrayList<>());
            group.add(s1);
            map.put(val, group);
        }
        return new ArrayList<>(map.values());
    }
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        int[] freq = new int[26];
        
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }
        
        for (int i : freq) {
            if (i != 0)
                return false;
        }
        
        return true;
    }
}
