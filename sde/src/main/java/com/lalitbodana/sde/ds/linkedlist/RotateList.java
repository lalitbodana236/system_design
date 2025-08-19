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
        System.out.println(k +" "+ len);
        int stepsToNewTail = len - k;
        
        System.out.println(stepsToNewTail);
        ListNode newTail = tail;
        System.out.println(newTail.data);
        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }
        System.out.println("val "+newTail.data);
        ListNode newHead = newTail.next;
        newTail.next = null;
        System.out.println("val "+newHead.data);
        return newHead;
    }
    
}
