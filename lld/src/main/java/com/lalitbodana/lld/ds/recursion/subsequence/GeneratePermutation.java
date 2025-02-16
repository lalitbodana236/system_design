package com.lalitbodana.lld.ds.recursion.subsequence;

public class GeneratePermutation {
    public static void main(String[] args) {

        generate("abc", "");
    }

    public static void generate(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            generate(newStr, ans + ch);
        }


    }
}
