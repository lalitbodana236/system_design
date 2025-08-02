package com.lalitbodana.resource.ds.stackandqueue;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        solve(new String[]{"2", "1", "+", "3", "*"});
    }
    
    public static void solve(String[] arr) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != "+" && arr[i] != "-" && arr[i] != "*") {
                stack.push(Integer.parseInt(arr[i]));
            } else {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                //  stack.push(num1 + arr[i]+num2);
                
            }
        }
    }
}
