package com.lalitbodana.lld.ds.linkedlist;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        ListNode head = LinkedListUtils.create(arr);

        LinkedListUtils.print(head);

        ListNode ansNode = deleteDuplicates(head);
        LinkedListUtils.print(ansNode);

//        int[] arr1 = {1,1,2,3,3};
//        ListNode head1 =  LinkedListUtils.create(arr1);
//        ListNode ansNode1 = deleteDuplicates(head1);
//        LinkedListUtils.print(ansNode1);
//
//        int[] arr2 = {1};
//        ListNode head2 =  LinkedListUtils.create(arr2);
//        ListNode ansNode2 = deleteDuplicates(head2);
//        LinkedListUtils.print(ansNode2);
//
//        int[] arr3 = {};
//        ListNode head3 =  LinkedListUtils.create(arr3);
//        ListNode ansNode3 = deleteDuplicates(head3);
//        LinkedListUtils.print(ansNode3);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.data == cur.next.data) {
                cur.next = cur.next.next;
            } else
                cur = cur.next;
        }

        return head;
    }
}
