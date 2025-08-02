package com.lalitbodana.sde.tuf.twopointer;

import java.util.HashSet;
import java.util.Set;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc";
        //Output: 10
        
        System.out.println(numberOfSubstringsOpt2(s));
        System.out.println(numberOfSubstringsOpt2("aaacb"));
        System.out.println(numberOfSubstringsOpt2("abc"));
    }
    
    public static int numberOfSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> freq = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == 'a' || ch == 'b' || ch == 'c') {
                    freq.add(ch);
                }
                
                if (freq.size() == 3) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static int numberOfSubstringsOpt1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> freq = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == 'a' || ch == 'b' || ch == 'c') {
                    freq.add(ch);
                }
                
                if (freq.size() == 3) {
                    count = count + (s.length() - j);
                    break;
                }
            }
        }
        return count;
    }
    
    public static int numberOfSubstringsOpt2(String s) {
        int count = 0;
        int[] lastseen = {-1, -1, -1};
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            lastseen[ch - 'a'] = right;
            if (lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1) {
                count = count + (1 + Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2])));
            }
            
        }
        
        return count;
    }
}
