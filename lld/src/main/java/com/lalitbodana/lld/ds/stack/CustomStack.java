package com.lalitbodana.lld.ds.stack;

import java.util.Stack;

public class CustomStack {
    public static void main(String[] args) {
        Stack stack = new Stack<>();
        stack.push(1L);
        stack.push(1.1);
        stack.push(1.1d);
        System.out.println(stack);
    }
}
