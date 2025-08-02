package com.lalitbodana.resource.ds.stackandqueue;

import java.util.Stack;

public class MinStack {
    private final Stack<Pair> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(val, stack.peek().min);
        stack.push(new Pair(val, min));
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public Integer top() {
        if (!stack.isEmpty()) {
            return stack.peek().val;
        }
        
        return null;
    }
    
    public Integer getMin() {
        if (!stack.isEmpty()) {
            return stack.peek().min;
        }
        
        return null;
    }
}

class Pair {
    int val;
    int min;
    
    public Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
