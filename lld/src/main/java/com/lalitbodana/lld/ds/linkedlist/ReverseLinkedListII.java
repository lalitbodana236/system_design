package com.lalitbodana.lld.ds.linkedlist;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        int[] head = {1, 2, 3, 4, 5};
        int left = 2, right = 4;
        ListNode root = LinkedListUtils.create(head);
        LinkedListUtils.print(root);

        reverseBetween(root, left, right);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode end = start;

        for (int i = left; i < right; i++) {
            end = end.next;
        }

        ListNode afterEnd = end.next;
        end.next = null;


        ListNode newHead = reverse(start);

        prev.next = newHead;
        start.next = afterEnd;

        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
