package com.lalitbodana.lld.ds.sorting;

import com.lalitbodana.lld.Utils;

public class Bubble {

    public static void main(String[] args) {
        int[] arr = {2, 25, -1, 15, 7};
        Utils.print(arr);
        sort(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1])
                    Utils.swap(arr, j, j + 1);

            }
            Utils.print(arr);
        }

    }
}
