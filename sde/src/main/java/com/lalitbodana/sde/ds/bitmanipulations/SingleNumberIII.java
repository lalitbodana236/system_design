package com.lalitbodana.sde.ds.bitmanipulations;

public class SingleNumberIII {
    public static void main(String[] args) {
        new SingleNumberIII().singleNumber(new int[]{2,3,5,2});
    }
    
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all numbers → gives xor = a ^ b
        //110
        //011
        //101
        //101
        //010
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        System.out.println(xor);
        // Step 2: Find rightmost set bit (where a and b differ)
        int diffBit = xor & -xor;  // isolates rightmost set bit
        System.out.println(diffBit);
        // Step 3: Partition into two groups
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num; // group 1
            } else {
                b ^= num; // group 2
            }
        }
        
        return new int[]{a, b};
    }
    
}
