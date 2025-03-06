package com.lalitbodana.lld.ds.stack;

import java.util.Stack;

public class InfixToPreFix {
    // Function to return precedence of operators
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3; // Exponentiation has the highest precedence
        }
        return -1;
    }

    // Function to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Function to convert infix to prefix
    public static String infixToPrefix(String infix) {
        // Step 1: Reverse the infix expression
        StringBuilder reversed = new StringBuilder(infix).reverse();

        // Swap '(' with ')' and vice versa
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            } else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }

        // Step 2: Convert reversed infix to postfix
        String postfix = infixToPostfix(reversed.toString());

        // Step 3: Reverse the postfix expression to get prefix
        return new StringBuilder(postfix).reverse().toString();
    }

    // Function to convert infix to postfix
    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            // If operand, add to output
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            // If '(', push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If ')', pop until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '('
            }
            // If operator, process precedence
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "(A-B/C)*(A/K-L)";
        String prefix = infixToPrefix(infix);

        System.out.println("Infix Expression: " + infix);
        System.out.println("Prefix Expression: " + prefix);
    }
}
