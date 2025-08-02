package com.lalitbodana.sde.grind169;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {
    public static void main(String[] args) {
        cookies(9, Arrays.asList(2, 7, 3, 6, 4, 6));
    }

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue(A);
        System.out.println(minHeap + " " + minHeap.peek());
        int count = 0;

        while (minHeap.size() > 1 && minHeap.peek() < k) {
            int firstVal = minHeap.poll();
            int secondVal = minHeap.poll();
            minHeap.add(firstVal + 2 * secondVal);
            count++;
        }

        if (minHeap.peek() > k) return count;
        else return -1;

    }

}
