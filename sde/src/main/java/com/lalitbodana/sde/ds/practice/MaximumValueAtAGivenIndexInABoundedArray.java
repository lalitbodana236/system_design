package com.lalitbodana.sde.ds.practice;

public class MaximumValueAtAGivenIndexInABoundedArray {
    public static void main(String[] args) {
    
    }
    
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum;
        
        while (low < high) {
            int mid = (low + high + 1) / 2;
            
            if (isPossible(n, index, mid, maxSum)) {
                low = mid; // try for a higher value
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    private boolean isPossible(int n, int index, int x, int maxSum) {
        long leftSum = calcSideSum(index, x - 1);
        long rightSum = calcSideSum(n - index - 1, x - 1);
        long total = leftSum + rightSum + x;
        
        return total <= maxSum;
    }
    
    private long calcSideSum(int length, int peak) {
        if (peak >= length) {
            long sum = (long) (peak + peak - length + 1) * length / 2;
            return sum;
        } else {
            long full = (long) (peak + 1) * peak / 2;
            long ones = (length - peak);
            return full + ones;
        }
    }
}
