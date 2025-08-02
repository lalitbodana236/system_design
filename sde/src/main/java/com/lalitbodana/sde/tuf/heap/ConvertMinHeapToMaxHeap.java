package com.lalitbodana.sde.tuf.heap;

public class ConvertMinHeapToMaxHeap {
    public static void main(String[] args) {
    
    }
    
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        
        // Start from the last internal node and heapify up to the root
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, n, i);
        }
        
        return nums;
    }
    
    private void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // Compare with left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // Compare with right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If the current node is not the largest, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            maxHeapify(arr, n, largest);
        }
    }
}
