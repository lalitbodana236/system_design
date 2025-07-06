package com.lalitbodana.lld.grind169;

public class GeneratePermutation {
    public static void main(String[] args) {
        String s = "abc";
        
        generatePermutation(s.toCharArray(), 0);
        
    }
    
    private static void generatePermutation(char[] s, int index) {
        if (s.length == index) {
            System.out.println(new String(s));
            return;
        }
        
        for (int i = index; i < s.length; i++) {
            swap(s, index, i);
            generatePermutation(s, index + 1);
            swap(s, index, i);
        }
    }
    
    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
