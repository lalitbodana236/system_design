package com.lalitbodana.sde.ds.bitmanipulations;


public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{1,2,3,5,2,1,3,5,2,3,5,1}));
    }
    
    public static int findNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    bitCount++;
                }
            }
            
            if (bitCount % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
