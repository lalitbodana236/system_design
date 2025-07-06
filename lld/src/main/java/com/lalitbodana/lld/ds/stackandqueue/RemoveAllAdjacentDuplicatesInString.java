package com.lalitbodana.lld.ds.stackandqueue;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
    
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            char ch = cArr[i];
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        
        String x = "";
        while (!stack.isEmpty()) {
            String val = String.valueOf(stack.pop());
            x += val;
            
        }
        
        return x;
    }
    
}
