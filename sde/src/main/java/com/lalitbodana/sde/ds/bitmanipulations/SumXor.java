package com.lalitbodana.sde.ds.bitmanipulations;

public class SumXor {
    public static void main(String[] args) {
        System.out.println(sumXor(10));
    }
    
    public static long sumXor(long n) {
        // Special case
        if (n == 0) return 1;
        
        int countZeroBits = 0;
        long temp = n;
        
        // Count the number of 0 bits in n
        while (temp > 0) {
            if ((temp & 1) == 0) countZeroBits++;
            temp >>= 1;
        }
        
        // Total possibilities = 2^countZeroBits
        return 1L << countZeroBits;
    }
}
