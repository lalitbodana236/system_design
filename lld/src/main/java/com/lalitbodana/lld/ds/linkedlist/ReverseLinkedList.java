package com.lalitbodana.lld.ds.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
    }
    
    public static void reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
    
    public ListNode reverseRec(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode node = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        
        return node;
    }
}
