package com.lalitbodana.sde.grind169;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder longestPal = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder pal1 = expandAroundCenter(s, i, i);
            StringBuilder pal2 = expandAroundCenter(s, i, i + 1);

            if (pal1.length() > longestPal.length()) {
                longestPal = pal1;
            }
            if (pal2.length() > longestPal.length()) {
                longestPal = pal2;
            }
        }

        return longestPal.toString();
    }

    private StringBuilder expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new StringBuilder(s.substring(left + 1, right));
    }
}
