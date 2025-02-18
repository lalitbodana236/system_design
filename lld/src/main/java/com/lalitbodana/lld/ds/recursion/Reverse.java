package com.lalitbodana.lld.ds.recursion;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr)
            System.out.print(i + " ");

        reverse(arr, 0, arr.length - 1);
        System.out.println();
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void reverse(int[] arr, int start, int end) {
        if (start >= end) return;
        swap(arr, start, end);
        reverse(arr, start + 1, end - 1);
    }

    public static void swap(int[] arr, int start, int end) {
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
    }


}
