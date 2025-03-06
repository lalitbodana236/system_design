package com.lalitbodana.lld.ds.stack;

import java.util.Stack;

public class InfixToPostFix {
    //infix to postfix
    // Method to get precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3; // Higher precedence for exponentiation
        }
        return -1;
    }

    // Method to convert infix to postfix
    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If character is an operand, add to result
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If character is '(', push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If character is ')', pop from stack until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '('
            }
            // Operator encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining elements in stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String infixExpr = "A+B*(C^D-E)";
        String postfixExpr = infixToPostfix(infixExpr);
        System.out.println("Infix Expression: " + infixExpr);
        System.out.println("Postfix Expression: " + postfixExpr);
    }


}
