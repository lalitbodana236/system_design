package com.lalitbodana.resource;

import java.util.List;

public class Utils {

    public static <T> void swap(T[] arr, int first, int second) {
        T temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void print(int[] arr) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static <T> void print(T[] arr) {
        System.out.println();
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static <T> void print(List<T> list) {
        System.out.println();
        for (T element : list) {
            System.out.println(element + " ");
        }
        System.out.println();
    }
}

