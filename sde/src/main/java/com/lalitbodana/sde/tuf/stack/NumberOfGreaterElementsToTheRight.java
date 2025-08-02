package com.lalitbodana.sde.tuf.stack;

import java.util.Stack;

public class NumberOfGreaterElementsToTheRight {
    
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int queries = 2;
        int[] indices = {0, 5};
        
        int[] ans = count_NGEs2(arr.length, arr, queries, indices);
        
        for (int i : ans) System.out.print(i + " ");
        
    }
    
    public static int[] count_NGEs(int N, int[] arr, int queries, int[] indices) {
        int[] ans = new int[queries];
        int j = 0;
        for (int idx : indices) {
            Stack<Integer> stack = new Stack<>();
            int count = 0;
            for (int i = idx; i < N; i++) {
                if (arr[i] > arr[idx]) {
                    count++;
                }
            }
            ans[j++] = count;
        }
        
        return ans;
        
    }
    
    public static int[] count_NGEsOpt(int N, int[] arr, int queries, int[] indices) {
        int[] ans = new int[queries];
        for (int i = 0; i < queries; i++) {
            int curr = arr[indices[i]];
            Stack<Integer> st = new Stack<>();
            int r = N - 1;
            while (r > indices[i]) {
                if (arr[r] > curr) {
                    st.push(arr[r]);
                }
                r--;
            }
            ans[i] = st.size();
        }
        return ans;
    }
    
    public static int[] count_NGEs2(int N, int[] arr, int queries, int[] indices) {
        int[] greaterCount = new int[N];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            greaterCount[i] = stack.size();
            stack.push(arr[i]);
        }
        
        int[] ans = new int[queries];
        for (int i = 0; i < queries; i++) {
            ans[i] = greaterCount[indices[i]];
        }
        
        return ans;
    }
    
}
