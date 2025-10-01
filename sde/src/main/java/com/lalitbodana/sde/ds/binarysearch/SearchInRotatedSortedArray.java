package com.lalitbodana.sde.ds.binarysearch;

public class SearchInRotatedSortedArray {
    
    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        s.search(new int[]{1}, 0);
    }
    
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            //left
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//right
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
