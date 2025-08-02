package com.lalitbodana.resource.ds.stackandqueue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack;
    
    public MyQueue() {
        stack = new Stack<>();
    }
    
    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(2);
        m.push(3);
        // System.out.println(m.peek());
        //System.out.println(m.pop());
        m.print();
    }
    
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<>();
        
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        
        stack.push(x);
        
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
    
    public void print() {
        for (int q : this.stack) {
            System.out.println(q);
            //  queue.add(queue.poll());
        }
    }
    
}
