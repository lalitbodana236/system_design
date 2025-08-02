package com.lalitbodana.sde.ds.linkedlist;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] head = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode node = LinkedListUtils.create(head);
        LinkedListUtils.print(node);
        ListNode node1 = removeNthFromEnd(node, n);
        LinkedListUtils.print(node1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            if (fast == null)
                return head;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        LinkedListUtils.print(fast);

        return dummy;
    }
}
