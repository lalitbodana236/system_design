package com.lalitbodana.sde.companywise.oracle;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n < 4 || n > 12) return res;
        
        
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    int d = n - (a + b + c);
                    if (d < 1 || d > 3) continue;
                    
                    int idx = 0;
                    String A = s.substring(idx, idx += a);
                    String B = s.substring(idx, idx += b);
                    String C = s.substring(idx, idx += c);
                    String D = s.substring(idx);
                    
                    if (valid(A) && valid(B) && valid(C) && valid(D)) {
                        res.add(A + "." + B + "." + C + "." + D);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean valid(String part) {
        
        if (part.length() == 0 || part.length() > 3) return false;
        
        if (part.length() > 1 && part.charAt(0) == '0') return false;
        
        int val = Integer.parseInt(part);
        return val >= 0 && val <= 255;
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int index, List<String> path, List<String> result) {
        // If we already have 4 parts and consumed entire string -> valid IP
        if (path.size() == 4 && index == s.length()) {
            result.add(String.join(".", path));
            return;
        }
        
        // If 4 parts but string not fully consumed -> invalid
        if (path.size() >= 4) return;
        
        // Try making each segment of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break; // substring out of range
            
            String segment = s.substring(index, index + len);
            
            // Check validity
            if ((segment.startsWith("0") && segment.length() > 1) || Integer.parseInt(segment) > 255) {
                continue;
            }
            
            // Choose
            path.add(segment);
            
            // Explore further
            backtrack(s, index + len, path, result);
            
            // Undo choice
            path.remove(path.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        RestoreIPAddresses sol = new RestoreIPAddresses();
        System.out.println(sol.restoreIpAddresses("25525511135"));
        System.out.println(sol.restoreIpAddresses("0000"));
        System.out.println(sol.restoreIpAddresses("101023"));
    }
}
