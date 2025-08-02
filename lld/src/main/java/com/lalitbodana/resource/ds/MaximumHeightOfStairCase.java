package com.lalitbodana.resource.ds;

public class MaximumHeightOfStairCase {
    public static void main(String[] args) {
        createStair(16);
    }

    public static void createStair(int n) {
        int i = 0;
        while (i < n) {

            for (int j = 0; j < i; j++) {
                System.out.print("[]");
                n -= j;
            }
            System.out.println();
            i++;
        }

        System.out.println(i - 1);
    }
}
