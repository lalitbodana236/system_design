package com.lalitbodana.sde.days21;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
//        merge(nums1, m, nums2, n);
//        for (Integer i : nums1) System.out.print(i + " ");
        
        System.out.println();
//        nums1 = new int[]{1};
//        m = 1;
//        nums2 = new int[0];
//        n = 0;
//        merge(nums1, m, nums2, n);
//        for (Integer i : nums1) System.out.print(i + " ");
        
        System.out.println();
        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        merge(nums1, m, nums2, n);
        for (Integer i : nums1) System.out.print(i + " ");
    }
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int idx = m + n - 1;
        System.out.println(idx + " " + i + " " + j);
        while (idx >= 0 && i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[idx] = nums1[i--];
            } else {
                nums1[idx] = nums2[j--];
            }
            idx--;
        }
    }
}
