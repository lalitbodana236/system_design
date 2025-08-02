package com.lalitbodana.sde.ds.practice;

import com.lalitbodana.sde.ds.linkedlist.LinkedListUtils;
import com.lalitbodana.sde.ds.linkedlist.ListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        LinkedListUtils.print(new ReverseNodesInKGroup().reverseKGroup(LinkedListUtils.create(new int[]{1, 2, 3, 4, 5}), 2));
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
        
        ListNode start = head;
        ListNode end = head;
        int count = 0;
        while (count < k && end != null) {
            end = end.next;
            count++;
        }
        
        if (count < k) {
            return start;
        }
        
        ListNode nextHead = reverseKGroup(end, k);
        ListNode reversed = reverse(start, end);
        
        start.next = nextHead;
        return reversed;
    }
    
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode current = start;
        ListNode temp = null;
        
        while (current != end) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
    }
}
