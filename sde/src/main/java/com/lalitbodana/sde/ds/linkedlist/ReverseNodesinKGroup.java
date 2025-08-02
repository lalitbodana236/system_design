package com.lalitbodana.sde.ds.linkedlist;

public class ReverseNodesinKGroup {
    public static void main(String[] args) {
        ListNode root = LinkedListUtils.create(new int[]{1, 2, 3, 4, 5});
        LinkedListUtils.print(new ReverseNodesinKGroup().reverseKGroup(root, 2));
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
        LinkedListUtils.print(reversed);
        
        start.next = nextHead;
        return reversed;
    }
    
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode current = start;
        while (current != end) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
    }
}
