package com.lalitbodana.sde.ds.stackandqueue;

import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4, 10, 5, 8, 20, 15, 3, 12};
        int[] arr1 = {5, 15, 20, 25, 12, 20};
        optimises(arr);
        System.out.println("-1 4 4 5 8 8 -1 3");
    }
    
    public static void optimises(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) System.out.print("-1" + " ");
            else System.out.print(stack.peek() + " ");
            stack.push(arr[i]);
        }
        
        // for (int i : stack)
        //   System.out.print(i + " ");
        
        System.out.println();
    }
}
