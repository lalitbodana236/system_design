package com.lalitbodana.lld.ds.linkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] list1 = {1, 2, 4}, list2 = {1, 3, 4};
        //Output: [1,1,2,3,4,4]

        ListNode l1 = LinkedListUtils.create(list1);
        LinkedListUtils.print(l1);

        ListNode l2 = LinkedListUtils.create(list2);

        LinkedListUtils.print(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data > list2.data) {
                dummy.next = list2;
                list2 = list2.next;
            } else {
                dummy.next = list1;
                list1 = list1.next;
            }
            dummy = dummy.next;
        }

        if (list1 != null) {
            dummy.next = list1;
        }
        if (list2 != null) {
            dummy.next = list2;
        }

        return head.next;
    }
}
