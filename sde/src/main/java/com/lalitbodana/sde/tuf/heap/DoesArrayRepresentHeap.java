package com.lalitbodana.sde.tuf.heap;

public class DoesArrayRepresentHeap {
    
    public static void main(String[] args) {
        System.out.println(isMaxHeap(new int[]{90, 15, 10, 7, 12, 2}, 6));
        System.out.println(isMaxHeap(new int[]{9, 15, 10, 7, 12, 11}, 6));
    }
    
    public static boolean isMaxHeap(int[] arr, int n) {
        // Check from root till the last internal node
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            
            // If left child exists and is greater than parent
            if (left < n && arr[i] < arr[left]) return false;
            
            // If right child exists and is greater than parent
            if (right < n && arr[i] < arr[right]) return false;
        }
        return true;
    }
}
