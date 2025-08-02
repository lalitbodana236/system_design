package com.lalitbodana.resource.ds.linkedlist;

public class LinkedListUtils {

    public static ListNode create(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;

        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }

        return head;
    }

    public static void print(ListNode node) {
        System.out.println("\nLinked List Representation:");
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
