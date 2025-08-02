package com.lalitbodana.resource.tuf.stack;

import java.util.Stack;

public class InfixToPostfix {
    
    public static void main(String[] args) {
        String s = "A*(B+C)/D";
        // Output:
        System.out.println("ABC+*D/".equals(infixToPostfix(s)));
        
        //abcd^e-fgh*+^*+i-
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
    
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuffer res = new StringBuffer();
        for (Character c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                res.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }
        
        while (!st.isEmpty())
            res.append(st.pop());
        return res.toString();
    }
    
    private static int precedence(char c) {
        
        if (c == '^') return 3;
        else if (c == '/' || c == '*') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
        
    }
}
