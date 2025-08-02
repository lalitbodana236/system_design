package com.lalitbodana.resource.tuf.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(searchRec(nums, 9, 0, nums.length - 1));
    }
    
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        
        return -1;
    }
    
    public static int searchRec(int[] nums, int target, int left, int right) {
        if (left > right) return -1;  // Base case: target not found
        
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return mid;
        } else if (target > nums[mid]) {
            return searchRec(nums, target, mid + 1, right);
        } else {
            return searchRec(nums, target, left, mid - 1);
        }
    }
}
