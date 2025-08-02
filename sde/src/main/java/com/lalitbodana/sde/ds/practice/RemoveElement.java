package com.lalitbodana.sde.ds.practice;

public class RemoveElement {
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        
        System.out.println(removeElement(nums, val));
        
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        
        System.out.println(removeElement(nums, val));
    }
    
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i : nums) {
            if (i != val) {
                nums[index++] = i;
            }
        }
        return index;
    }
    
}
