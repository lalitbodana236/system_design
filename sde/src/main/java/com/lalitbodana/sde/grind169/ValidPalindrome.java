package com.lalitbodana.sde.grind169;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        vp.isPalindrome(s);
    }
    
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(ch);
            }
        }
        ch = sb.toString().toCharArray();
        while (left < right) {
            if (ch[left] != ch[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
