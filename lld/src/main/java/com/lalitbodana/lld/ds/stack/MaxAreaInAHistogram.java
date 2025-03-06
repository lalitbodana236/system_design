package com.lalitbodana.lld.ds.stack;

public class MaxAreaInAHistogram {
    public static void main(String[] args) {
        int[] a = {4, 2, 1, 5, 6, 3, 2, 4, 2};

    }

    public static void brute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int left = i;
            int right = i;
            while (arr[left] >= arr[i]) {
                left--;
            }

            while (arr[right] >= arr[i]) {
                right++;
            }

            int area = (right - left - 1) * arr[i];
        }
    }
}
