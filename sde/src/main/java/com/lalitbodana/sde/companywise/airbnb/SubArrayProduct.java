package com.lalitbodana.sde.companywise.airbnb;

public class SubArrayProduct {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;

        helper(nums, k);
    }

    private static int helper(int[] nums, int k) {

        if (k <= 1) return 0;

        int totalCount = 0;
        int product = 1;


        for (int left = 0, right = 0; right < nums.length; right++) {

            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
                System.out.println(product);
            }

            totalCount += right - left + 1;

        }

        return totalCount;
    }
}
