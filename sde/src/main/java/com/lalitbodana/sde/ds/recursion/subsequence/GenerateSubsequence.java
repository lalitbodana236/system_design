package com.lalitbodana.sde.ds.recursion.subsequence;

public class GenerateSubsequence {

    public static void main(String[] args) {
        subsequence("abc", "");
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

        //call-01 part of an answer
        subsequence(newStr, ans + ch);

        //call-02 not part of an answer
        subsequence(newStr, ans);
    }

}
