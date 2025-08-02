package com.lalitbodana.resource.tuf.binarysearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsertOpt1(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsertOpt1(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsertOpt1(new int[]{1, 3, 5, 6}, 7));
    }
    
    public static int searchInsertOpt1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        
        return nums.length;
    }
}
