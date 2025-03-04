package com.lalitbodana.lld.ds.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        //Output: 10
        System.out.println(largestRectangleArea(heights));
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
