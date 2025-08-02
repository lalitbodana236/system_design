package com.lalitbodana.sde.ds.practice;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] cArray = s.toCharArray();
        
        int left = 0;
        int right = cArray.length - 1;
        
        while (left < right) {
            
            while (!Character.isLetterOrDigit(cArray[left])) left++;
            while (!Character.isLetterOrDigit(cArray[right])) right--;
            
            if (Character.isAlphabetic(cArray[left]) && Character.isAlphabetic(cArray[right])) {
                if (cArray[left] != cArray[right]) {
                    return false;
                }
                left++;
                right--;
                // continue;
            }
            
            
        }
        
        return true;
    }
    
    
    public boolean isPalindromeOpt(String s) {
        s = s.toLowerCase();
        char[] cArray = s.toCharArray();
        
        int left = 0;
        int right = cArray.length - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(cArray[left])) left++;
            while (right > left && !Character.isLetterOrDigit(cArray[right])) right--;
            
            if (Character.isAlphabetic(cArray[left]) && Character.isAlphabetic(cArray[right])) {
                if (cArray[left] != cArray[right]) {
                    return false;
                }
                left++;
                right--;
                // continue;
            }
            
            
        }
        
        return true;
    }
    
    public boolean isPalindrome(String s, int left, int right) {
        
        
        while (left < right) {
            if (Character.isAlphabetic(s.charAt(left)) && Character.isAlphabetic(s.charAt(right))) {
                if (s.charAt(left) != s.charAt(left)) {
                    return false;
                }
                left++;
                right--;
            }
            
            
        }
        
        return true;
    }
}
