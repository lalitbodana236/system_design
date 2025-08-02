package com.lalitbodana.resource.ds.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class CustomQueue {
    public static void main(String[] args) {
        Queue q = new LinkedList();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.poll());
        System.out.println("queue " + q);
        System.out.println(q.peek());
        System.out.println("queue" + q);
        
        
    }
}
