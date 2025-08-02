package com.lalitbodana.resource.ds.stackandqueue;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] a = {3, 10, 5, 1, 15, 10, 7, 6};
        
        // 1 5 1 -1 10 7 6 -1
        optimise(a);
        System.out.println("1 5 1 -1 10 7 6 -1");
    }
    
    public static void optimise(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop(); // Remove elements that are greater or equal
            }
            
            result[i] = stack.isEmpty() ? -1 : stack.peek(); // Store next smaller element
            stack.push(arr[i]); // Push current element onto stack
        }
        
        for (int i : result)
            System.out.print(i + " ");
        
        System.out.println();
    }
    
    public static void bruteForce(int[] arr) {
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    a[i] = arr[j];
                    break;
                }
            }
        }
        for (int i : a)
            System.out.print(i + " ");
        
        System.out.println();
    }
}
