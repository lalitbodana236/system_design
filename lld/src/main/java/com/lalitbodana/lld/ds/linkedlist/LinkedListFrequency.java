package com.lalitbodana.lld.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListFrequency {
    public static void main(String[] args) {
        int[] head = {1, 1, 2, 1, 2, 3};

        LinkedListUtils.print(frequenciesOfElements(LinkedListUtils.create(head)));
        //Output: [3,2,1]
    }

    public static ListNode frequenciesOfElements(ListNode head) {
        ListNode cur = head;
        Map<Integer, Integer> map = new HashMap<>();

        while (cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode root = dummy;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            root.next = new ListNode(m.getValue());
            root = root.next;
        }

        return dummy.next;
    }

    public ListNode frequenciesOfElementsOptimised(ListNode head) {
        int maxValue = 100000;
        int[] frequencies = new int[maxValue];
        ListNode current = head;


        while (current != null) {
            frequencies[current.val - 1]++;
            current = current.next;
        }

        ListNode freqHead = new ListNode(0);
        current = freqHead;


        for (int i = 0; i < maxValue; i++) {
            if (frequencies[i] > 0) {
                current.next = new ListNode(frequencies[i]);
                current = current.next;
            }
        }
        return freqHead.next;
    }
}
