package com.lalitbodana.sde.ds.binarysearch;

public class ImplementLowerBound {
    public static int lowerBound(int[] arr, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) {
                // lower bound found:
                return i;
            }
        }
        return n;
    }
    
    public static int lowerBoundOpt(int[] arr, int n, int x) {
        int left = 0;
        int right = arr.length - 1;
        int ans = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] >= x) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int n = 5, x = 9;
        int ind = lowerBoundOpt(arr, n, x);
        System.out.println("The lower bound is the index: " + ind);
    }
}
