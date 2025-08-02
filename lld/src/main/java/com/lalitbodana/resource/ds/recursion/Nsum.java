package com.lalitbodana.resource.ds.recursion;

public class Nsum {

    public static void main(String[] args) {
        System.out.println(sum(2));
    }

    public static int sum(int n) {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }
}
