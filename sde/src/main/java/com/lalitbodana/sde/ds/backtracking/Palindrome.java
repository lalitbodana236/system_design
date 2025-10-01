package com.lalitbodana.sde.ds.backtracking;

public class Palindrome {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(isValid("aba", 0, s.length() - 1));
    }

    public static boolean isValid(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isValid(s, start + 1, end - 1);

    }
}
