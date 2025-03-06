package com.lalitbodana.lld.ds.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        //Output: 10
        maxArea(heights);
    }

    public static void maxArea(int[] arr) {
        int maxArea = 0;
        int[] ps = prevSmaller(arr);
        int[] ns = nextSmaller(arr);
        for (int i = 0; i < arr.length; i++) {
            int cur = (ns[i] - ps[i] - 1) * arr[i];
            maxArea = Math.max(maxArea, cur);
        }

        System.out.println(maxArea);
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

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // Add zero height at the end to clear the stack

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                System.out.println(height * width);
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }


    public static void bruteForce(int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i;
            int right = i;

            while (left >= 0 && arr[left] >= arr[i]) {
                left--;
            }

            while (right < arr.length && arr[right] >= arr[i]) {
                right++;
            }

            int area = (right - left - 1) * arr[i];
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }

}
