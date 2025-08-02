package com.lalitbodana.sde.ds.linkedlist;

public class RotateList {
    
    public static void main(String[] args) {
        
        LinkedListUtils.print(new RotateList().rotateRight(LinkedListUtils.create(new int[]{1, 2, 3, 4, 5}), 2));
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        
        tail.next = head;
        k = k % len;
        
        int stepsToNewTail = len - k;
        ListNode newTail = tail;
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
    
}
