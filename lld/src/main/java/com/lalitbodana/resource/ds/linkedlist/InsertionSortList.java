package com.lalitbodana.resource.ds.linkedlist;

public class InsertionSortList {
    public static void main(String[] args) {
    
    }
    
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        
        while (curr != null) {
            ListNode prev = dummy;
            
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            
            ListNode nextTemp = curr.next;
            
            curr.next = prev.next;
            prev.next = curr;
            
            curr = nextTemp;
        }
        
        return dummy.next;
    }
    
}
