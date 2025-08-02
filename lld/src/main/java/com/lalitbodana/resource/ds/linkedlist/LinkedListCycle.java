package com.lalitbodana.resource.ds.linkedlist;

public class LinkedListCycle {
    public static void main(String[] args) {
        int[] head = {3, 2, 0, -4};
        int pos = 1;
        ListNode node = LinkedListUtils.create(head);

        LinkedListUtils.print(node);
    }
}
