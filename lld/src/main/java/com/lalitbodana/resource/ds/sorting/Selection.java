package com.lalitbodana.resource.ds.sorting;

import com.lalitbodana.resource.Utils;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {2, 25, -1, 15, 7};
        Utils.print(arr);
        sort(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            Utils.swap(arr, i, minIdx);
            Utils.print(arr);
        }
    }
}
