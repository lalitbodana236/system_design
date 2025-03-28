package com.lalitbodana.lld.grind169;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        vp.isValid("()");
    }

    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char c : ch) {
            if ('(' == c || '{' == c || '[' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isCheck(stack.pop(), c)) {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    public boolean isCheck(char old, char temp) {
        return (('(' == old && temp == ')') || ('[' == old && temp == ']') || ('{' == old && temp == '}'));
    }
}
