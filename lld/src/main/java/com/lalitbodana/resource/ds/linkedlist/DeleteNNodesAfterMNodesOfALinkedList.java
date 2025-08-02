package com.lalitbodana.resource.ds.linkedlist;

public class DeleteNNodesAfterMNodesOfALinkedList {
    public static void main(String[] args) {
        int[] head = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int m = 2, n = 3;
        ListNode root = LinkedListUtils.create(head);
        LinkedListUtils.print(root);


        LinkedListUtils.print(deleteNodes(root, m, n));


        int[] head1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int m1 = 1, n1 = 3;
        ListNode root1 = LinkedListUtils.create(head1);
        LinkedListUtils.print(root1);


        LinkedListUtils.print(deleteNodes(root1, m1, n1));
        // Output: [1,2,6,7,11,12]
    }

    public static ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head;
        int index = 1;

        while (cur != null) {
            while (index < m && cur != null) {
                cur = cur.next;
                index++;
            }
            //  LinkedListUtils.print(cur);
            if (index == m) {
                System.out.println("inside remove");
                int deleteIndex = 0;
                ListNode temp = cur;


                while (deleteIndex < n && temp != null && temp.next != null) {
                    System.out.println("inside while");
                    //  LinkedListUtils.print(temp);
                    temp = temp.next;
                    deleteIndex++;
                }
                if (temp != null)
                    cur.next = temp.next;
                index = 0;
            }
        }

        return head;
    }
}
