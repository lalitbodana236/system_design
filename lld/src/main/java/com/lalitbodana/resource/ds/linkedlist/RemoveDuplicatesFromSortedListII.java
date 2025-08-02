package com.lalitbodana.resource.ds.linkedlist;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = LinkedListUtils.create(arr);

        LinkedListUtils.print(head);

        ListNode ansNode = deleteDuplicates(head);
        LinkedListUtils.print(ansNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.data == current.next.data) {
                current = current.next;
            }

            if (prev.next == current) {
                prev = prev.next;
            } else {
                prev.next = current.next;
            }

            current = current.next;
        }

        return dummy.next;
    }
}
