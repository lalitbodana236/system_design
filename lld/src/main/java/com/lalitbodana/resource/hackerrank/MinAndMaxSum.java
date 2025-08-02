package com.lalitbodana.resource.hackerrank;

import java.util.Arrays;
import java.util.List;

public class MinAndMaxSum {
    public static void main(String[] args) {
        miniMaxSum(Arrays.asList(1, 3, 5, 7, 9));
    }

    public static void miniMaxSum(List<Integer> arr) {
        long totalSum = 0;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int num : arr) {
            totalSum += num;
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        long minSum = totalSum - maxVal;
        long maxSum = totalSum - minVal;


        System.out.println(minSum + " " + maxSum);


    }

}
