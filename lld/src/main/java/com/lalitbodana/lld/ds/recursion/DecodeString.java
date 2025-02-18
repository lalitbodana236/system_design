package com.lalitbodana.lld.ds.recursion;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));

        String s1 = "2[abc]3[cd]ef";
        System.out.println("abcabccdcdcdef" + " " + decodeString(s1));
    }

    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number (handles multi-digit numbers like "10[z]")
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Push the number and current string to stacks
                numStack.push(num);
                strStack.push(currentStr);
                // Reset for next part
                num = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                // Pop from stacks and decode
                int repeatTimes = numStack.pop();
                StringBuilder decodedStr = strStack.pop();
                // Repeat the current substring
                for (int i = 0; i < repeatTimes; i++) {
                    decodedStr.append(currentStr);
                }
                currentStr = decodedStr;
            } else {
                // Append characters to the current string
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }
}
