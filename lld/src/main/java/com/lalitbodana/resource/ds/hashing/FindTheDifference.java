package com.lalitbodana.resource.ds.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";
        difference(s, t);
        difference("", "y");
    }

    public static char difference(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return (char) (i + 'a');
            }
        }
        return 'z';
    }

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() != 0) {
                return m.getKey();
            }
        }
        return 'z';
    }
}
