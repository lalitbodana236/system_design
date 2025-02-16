package com.lalitbodana.lld.ds.slindingwindow;

import java.util.Arrays;

public class FindClosestSum {

    public static void main(String[] args) {
        int[] num1 = {1, 4, 5, 7};
        int[] num2 = {10, 20, 30, 40};
        twoSumClosest(num1, num2, 32);

        //int[] num1={1,4,5,7};
        //int[] num2={10,20,30,40};
        twoSumClosest(num1, num2, 50);
    }

    public static void twoSumClosest(int[] nums1, int[] nums2, int target) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int min = Integer.MAX_VALUE;

        for (int i : nums1) {
            int temp = Integer.MAX_VALUE;
            for (int j : nums2) {
                int sum = i + j;
                //  System.out.println("sum "+sum+" "+Math.abs(target - sum));
                int diff = Math.abs(target - sum);
                min = Math.min(min, diff);
                if (min < temp) {
                    temp = min;
                    System.out.println(i + " " + j);
                }
            }
        }
        //  System.out.println(min);

    }
}
