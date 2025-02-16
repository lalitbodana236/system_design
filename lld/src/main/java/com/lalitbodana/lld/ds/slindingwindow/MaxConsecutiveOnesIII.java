package com.lalitbodana.lld.ds.slindingwindow;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        //Output: 6
        System.out.println(longestOnesBruteForce(nums, k));
        System.out.println(longestOnesOptimal(nums, k));

    }

    public static int longestOnesBruteForce(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int zero = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) zero++;
                if (zero <= k) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public static int longestOnesOptimal(int[] nums, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        int zero = 0;
        while (right < nums.length) {
            if (nums[right] == 0) zero++;
            while (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }

            if (zero <= k) max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
