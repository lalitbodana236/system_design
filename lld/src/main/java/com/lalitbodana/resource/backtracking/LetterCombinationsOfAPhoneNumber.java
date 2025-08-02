package com.lalitbodana.resource.backtracking;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    
    public static void main(String[] args) {
        letterCombinations("23");
    }
    
    public static List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        
        List<String> combination = new ArrayList<>();
        if (digits.isEmpty()) return combination;
        
        
        helper(map, combination, digits, 0, "");
        
        return combination;
    }
    
    private static void helper(Map<Character, List<Character>> map, List<String> combination, String digits, int idx, String ans) {
        if (idx == digits.length()) {
            combination.add(ans);
            return;
        }
        
        List<Character> characterList = map.get(digits.charAt(idx));
        for (int i = 0; i < characterList.size(); i++) {
            ans += characterList.get(i);
            
            helper(map, combination, digits, idx + 1, ans);
            ans = ans.substring(0, ans.length() - 1);
        }
    }
    
}
