package com.lalitbodana.resource.tuf.binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
        f.searchRangeOpt1(new int[]{5, 7, 7, 8, 8, 10}, 8);
        f.searchRangeOpt1(new int[]{5, 7, 7, 8, 6, 10}, 6);
        f.searchRangeOpt1(new int[0], 0);
    }
    
    public void searchRangeOpt1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        int first = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        left = 0;
        right = nums.length - 1;
        
        int last = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(first + " " + last);
        
    }
    
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        int end = upperBound(nums, target) - 1;
        
        // Edge case: if target not found
        if (start >= nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        
        return new int[]{start, end};
    }
    
    public int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
}
