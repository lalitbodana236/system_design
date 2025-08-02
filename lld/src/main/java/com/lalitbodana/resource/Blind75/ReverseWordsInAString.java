package com.lalitbodana.resource.Blind75;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
    
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        String ans = "";
        int spaceCount = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            if (Character.isSpaceChar(ch[i])) {
                if (spaceCount == 0 && ans != null) {
                    sb.append(ans + " ");
                    ans = "";
                }
                
                spaceCount++;
            } else {
                sb.insert(0, ch[i]);
                //  ans = ch[i] + ans;
                spaceCount = 0;
            }
        }
        sb.append(ans);
        System.out.println(sb);
        return sb.toString().trim();
    }
}
