package com.lalitbodana.lld.ds.linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] l1 = {2, 4, 3}, l2 = {5, 6, 4};
        //Output: [7,0,8]
        //Explanation: 342 + 465 = 807.
        ListNode list1 = LinkedListUtils.create(l1);

        ListNode list2 = LinkedListUtils.create(l2);

        LinkedListUtils.print(addTwoNumbers(list1, list2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode head = root;
        int carry = 0;

        ListNode first = l1;
        ListNode second = l2;

        while (first != null || second != null) {
            int val1 = first != null ? first.data : 0;
            int val2 = second != null ? second.data : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);

            head = head.next;
            if (first != null) first = first.next;
            if (second != null) second = second.next;

        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return root.next;
    }
}
