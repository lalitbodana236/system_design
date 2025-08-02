package com.lalitbodana.sde.companywise.nielsen;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        //  System.out.println(isAnagram("nat", "tan"));
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
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
    
    public static boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> freqMap = new HashMap<>();
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            freqMap.put(ch1, freqMap.getOrDefault(ch1, 0) + 1);
            freqMap.put(ch2, freqMap.getOrDefault(ch2, 0) - 1);
        }
        
        for (Map.Entry<Character, Integer> freq : freqMap.entrySet()) {
            if (freq.getValue() != 0) return false;
        }
        return true;
    }
}
