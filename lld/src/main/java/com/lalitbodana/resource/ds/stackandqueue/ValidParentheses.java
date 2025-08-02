package com.lalitbodana.resource.ds.stackandqueue;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
    
    private static Boolean isValid(String bracket) {
        Stack<Character> stack = new Stack<>();
        for (Character c : bracket.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isCheck(stack.pop(), c))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    
    private static boolean isCheck(Character open, Character close) {
        System.out.println(open + " " + close);
        return ((open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']'));
    }
}
