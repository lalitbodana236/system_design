package com.lalitbodana.sde.ds.twopointer;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarraysOpt1(nums, k));
        
        nums = new int[]{2, 4, 6};
        k = 1;
        System.out.println(numberOfSubarraysOpt1(nums, k));
        
        nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        k = 2;
        System.out.println(numberOfSubarraysOpt1(nums, k));
        
        
    }
    
    public static int numberOfSubarraysOpt1(int[] nums, int k) {
        return addMost(nums, k) - addMost(nums, k - 1);
    }
    
    private static int addMost(int[] nums, int k) {
        if (k < 0) return 0;
        int count = 0, left = 0, oddCount = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) oddCount++;
            while (oddCount > k) {
                if (nums[left] % 2 != 0) oddCount--;
                left++;
            }
            count += right - left + 1; // ✅ all subarrays ending at 'right'
        }
        return count;
    }
    
    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int oddCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 != 0) {
                    oddCount++;
                }
                
                if (oddCount == k) {
                    count++;
                } else if (oddCount > k) {
                    break;
                }
            }
        }
        return count;
    }
}
