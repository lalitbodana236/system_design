package com.lalitbodana.sde.ds.twopointer;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        
        System.out.println(longestOnes(nums, k));
        
        nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        k = 3;
        System.out.println(longestOnes(nums, 3));
    }
    
    /*
        TC:O(N^2)
    */
    public static int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int zeroCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeroCount++;
                }
                
                if (zeroCount > k) {
                    break;
                }
                
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        
        return maxLength;
    }
    
    /*
    TC:O(2N)
*/
    public int longestOnesOpt1(int[] nums, int k) {
        int maxLength = 0;
        int left = 0, right = 0, zeroCount = 0;
        while (right < nums.length) {
            if (nums[right] == 0)
                zeroCount++;
            
            while (zeroCount > k) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
    
    /*
   TC:O(N)
*/
    public int longestOnesOpt2(int[] nums, int k) {
        int maxLength = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        while (right < n) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
    
}
