package com.lalitbodana.sde.tuf.binarysearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }
    
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
        }
        
        return min;
    }
    
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return nums[left];
    }
}
