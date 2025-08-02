package com.lalitbodana.sde.ds.practice;

import com.lalitbodana.sde.ds.linkedlist.LinkedListUtils;
import com.lalitbodana.sde.ds.linkedlist.ListNode;

public class ReverseLinkedListII {
    
    public static void main(String[] args) {
        ListNode n = new ReverseLinkedListII().reverseBetween(LinkedListUtils.create(new int[]{1, 2, 3, 4, 5}), 2, 4);
        // = new ReverseLinkedListII().reverse(LinkedListUtils.create(new int[]{1, 2, 3, 4, 5}), 4);
        LinkedListUtils.print(n);
        
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        ListNode cur = prev.next;
        ListNode next = null;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        
        return dummy.next;
    }
    
    public ListNode reverse(ListNode head, int left, int right) {
        if (right == left || head == null || head.next == null) {
            return head;
        }
        
        ListNode node = reverse(head.next, left + 1, right);
        
        head.next.next = head;
        head.next = null;
        
        return node;
        
    }
}
