package com.lalitbodana.lld.tuf.binarysearch;

public class ImplementUpperBound {
    
    public static int upperBound(int[] arr, int x) {
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                // lower bound found:
                return i;
            }
        }
        return arr.length;
    }
    
    public static int upperBoundOpt(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int ans = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > x) {  // ✅ we want the first > x
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(upperBoundOpt(new int[]{1, 2, 2, 3}, 2));
        System.out.println(upperBoundOpt(new int[]{3, 5, 8, 15}, 9));
    }
    
    
}
