package com.lalitbodana.lld.grind169;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(141));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int oldVal = x;
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return oldVal == rev;
    }
}
