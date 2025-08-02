package com.lalitbodana.resource.ds.recursion;

public class CountWaysToClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n == 1 || n == 0)
            return 1;

        //return climbStairs(n - 1) + climbStairs(n - 2);

        int prev = 1, cur = 1;
        for (int i = 2; i <= n; i++) {
            int temp = cur;
            cur = prev + cur;
            prev = temp;
        }
        return cur;
    }
}
