package com.lalitbodana.sde.grind169;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        List<String> result = new ArrayList<>();
        generateSubsequences(s, 0, "", result);
        System.out.println(result);
    }
    
    static void generateSubsequences(String s, int index, String current, List<String> result) {
        if (index == s.length()) {
            result.add(current);
            return;
        }
        
        // Include the current character
        generateSubsequences(s, index + 1, current + s.charAt(index), result);
        
        // Exclude the current character
        generateSubsequences(s, index + 1, current, result);
    }
}
