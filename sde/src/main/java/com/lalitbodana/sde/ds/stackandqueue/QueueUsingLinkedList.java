package com.lalitbodana.sde.ds.stackandqueue;

public class QueueUsingLinkedList {
    
    QueueNode front, rear;
    
    //Function to push an element into the queue.
    void push(int a) {
        QueueNode newNode = new QueueNode(a);
        if (rear == null) {
            rear = front = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        
    }
    
    //Function to pop front element from the queue.
    int pop() {
        if (front == null) {
            return -1;
        }
        if (front == rear) {
            int head = front.data;
            front = rear = null;
            return head;
        }
        int head = front.data;
        front = front.next;
        return head;
    }
    
    class QueueNode {
        int data;
        QueueNode next;
        
        QueueNode(int a) {
            data = a;
            next = null;
        }
    }
}
