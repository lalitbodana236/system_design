package com.lalitbodana.sde.ds.practice;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public static void main(String[] args) {
    
    }
    
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            if (mapST.containsKey(cs)) {
                if (mapST.get(cs) != ct) return false;
            } else {
                mapST.put(cs, ct);
            }
            
            if (mapTS.containsKey(ct)) {
                if (mapTS.get(ct) != cs) return false;
            } else {
                mapTS.put(ct, cs);
            }
        }
        
        return true;
    }
    
    
    public boolean isIsomorphicOptimised(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] mapST = new int[256]; // Maps from s -> t
        int[] mapTS = new int[256]; // Maps from t -> s
        
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            // If already mapped, it should be consistent
            if (mapST[cs] == 0 && mapTS[ct] == 0) {
                mapST[cs] = ct;
                mapTS[ct] = cs;
            } else if (mapST[cs] != ct || mapTS[ct] != cs) {
                return false;
            }
        }
        
        return true;
    }
    
}
