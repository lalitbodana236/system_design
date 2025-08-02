package com.lalitbodana.sde.ds.stackandqueue;

import java.util.Stack;

public class LargestAreaSubmaterixWithAll {
    public static void main(String[] args) {
    
    }
    
    public static int largestArea(int[][] arr) {
        int[] curRow = arr[0];
        int maxArea = maxHistorgram(curRow);
        
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    curRow[j] += 1;
                }
            }
            int curAns = maxHistorgram(curRow);
            maxArea = Math.max(maxArea, curAns);
        }
        
        return maxArea;
        
    }
    
    public static int maxHistorgram(int[] arr) {
        int maxArea = 0;
        int[] ps = prevSmaller(arr);
        int[] ns = nextSmaller(arr);
        for (int i = 0; i < arr.length; i++) {
            int cur = (ns[i] - ps[i] - 1) * arr[i];
            maxArea = Math.max(maxArea, cur);
        }
        
        System.out.println(maxArea);
        return maxArea;
    }
    
    
    public static int[] prevSmaller(int[] arr) {
        int[] ps = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            ps[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(i);
        }
        
        return ps;
    }
    
    public static int[] nextSmaller(int[] arr) {
        int[] ns = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            ns[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(i);
        }
        return ns;
    }
}
