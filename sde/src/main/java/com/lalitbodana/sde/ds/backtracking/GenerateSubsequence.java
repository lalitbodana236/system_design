package com.lalitbodana.sde.ds.backtracking;

public class GenerateSubsequence {

    public static void main(String[] args) {
        subsequence("abcde", "");
    }

    public static void subsequence(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //take out charachter at 0th index;
        char ch = str.charAt(0);

        //prepare new string
        String newStr = str.substring(1);
        System.out.println("newstr "+ newStr);
        //call-01 part of an answer
        subsequence(newStr, ans + ch);

        //call-02 not part of an answer
        subsequence(newStr, ans);
    }

}
