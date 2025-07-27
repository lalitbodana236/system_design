package com.lalitbodana.lld.ds.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;
    
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public static void main(String[] args) {
        MyStack m = new MyStack();
        m.push(1);
        m.push(2);
        m.push(3);
        m.print();
        
        
    }
    
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
            
        }
        
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
    
    public void print() {
        for (int q : this.queue) {
            System.out.println(q);
            //  queue.add(queue.poll());
        }
    }
}
