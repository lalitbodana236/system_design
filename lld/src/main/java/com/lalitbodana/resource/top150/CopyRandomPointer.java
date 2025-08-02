package com.lalitbodana.resource.top150;

import com.lalitbodana.resource.ds.linkedlist.LinkedListUtils;
import com.lalitbodana.resource.ds.linkedlist.ListNode;

public class CopyRandomPointer {
    public static void main(String[] args) {
        ListNode node = LinkedListUtils.create(new int[]{7, 13, 11, 10, 1});
        
        CopyRandomPointer c = new CopyRandomPointer();
        c.copy(node);
        
    }
    
    public void copy(ListNode head) {
        
        
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = new ListNode(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        cur = head;
        LinkedListUtils.print(cur);
        
        
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        cur = head;
        LinkedListUtils.print(cur);
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        while (cur != null) {
            temp.next = cur.next;
            cur = cur.next.next;
            temp = temp.next;
        }
        
        LinkedListUtils.print(dummy.next);
    }
}
