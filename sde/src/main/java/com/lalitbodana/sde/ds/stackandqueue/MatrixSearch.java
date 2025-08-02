package com.lalitbodana.sde.ds.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {
    public static void main(String[] args) {
        
        int B = 3;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 3, 5, 7)));
        list.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        list.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));
        
        // Printing the list to verify
        // System.out.println(list);
        System.out.println(searchMatrix(list, B));
    }
    
    public static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int ans = 0;
        for (ArrayList<Integer> tempList : A) {
            ans = binarySearch(tempList, B);
            //   System.out.println(ans);
            if (ans > -1) {
                return 0;
            }
        }
        return 0;
    }
    
    public static int binarySearch(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
