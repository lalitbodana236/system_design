package com.lalitbodana.sde.ds.twopointer;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        // new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2);
        new LongestRepeatingCharacterReplacement().characterReplacementOpt1("AABABBA", 1);
    }
    
    public int characterReplacement(String s, int k) {
        
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            int changes = 0;
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                freq[ch - 'A']++;
                maxFreq = Math.max(maxFreq, freq[ch - 'A']);
                
                changes = (j - i + 1) - maxFreq;
                
                if (changes > k)
                    break;
                
                maxLength = Math.max(maxLength, j - i + 1);
                
                
            }
        }
        
        System.out.println(maxLength);
        return maxLength;
    }
    
    public int characterReplacementOpt1(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            
            maxCount = Math.max(maxCount, freq[ch - 'A']);
            
            // Debug print
            System.out.println("Window: " + s.substring(left, right + 1));
            System.out.println("Char Frequencies: A=" + freq[0] + ", B=" + freq['B' - 'A']);
            System.out.println("Window Size: " + (right - left + 1) + ", maxCount: " + maxCount);
            
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                System.out.println("Shrinking window. New left: " + left);
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
            System.out.println("Current Max Length: " + maxLength);
            System.out.println("------------");
        }
        
        return maxLength;
    }
    
    public int characterReplacementOpt2(String s, int k) {
        
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            
            if ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        
        System.out.println(maxLength);
        return maxLength;
    }
    
    
}
