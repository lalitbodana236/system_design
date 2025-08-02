package com.lalitbodana.sde.tuf.twopointer;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        
        int[] targetFreq = new int[128];
        int[] windowFreq = new int[128];
        
        // Fill target frequency map
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }
        
        int required = t.length();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (right < s.length()) {
            char chRight = s.charAt(right);
            if (targetFreq[chRight] > 0) {
                windowFreq[chRight]++;
                if (windowFreq[chRight] <= targetFreq[chRight]) {
                    required--;
                }
            }
            
            // Shrink window until it becomes invalid
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                char chLeft = s.charAt(left);
                if (targetFreq[chLeft] > 0) {
                    windowFreq[chLeft]--;
                    if (windowFreq[chLeft] < targetFreq[chLeft]) {
                        required++;
                    }
                }
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
    
    private static boolean containsAllChars(String s, String t) {
        int[] sCount = new int[128];
        int[] tCount = new int[128];
        
        for (char c : s.toCharArray()) sCount[c]++;
        for (char c : t.toCharArray()) tCount[c]++;
        
        for (int i = 0; i < 128; i++) {
            if (tCount[i] > sCount[i]) return false;
        }
        return true;
    }
}
