package com.lalitbodana.sde.ds.bitmanipulations;

public class CountBits {
    
    static final int MOD = 1000000007;
    
    public static int countBits(int N, int[] A) {
        long ans = 0;
        
        for (int bit = 0; bit < 32; bit++) {
            long countOnes = 0;
            for (int num : A) {
                if ((num & (1 << bit)) != 0) {
                    countOnes++;
                }
            }
            
            long countZeros = N - countOnes;
            long contrib = (countOnes * countZeros * 2) % MOD;
            ans = (ans + contrib) % MOD;
        }
        
        return (int) ans;
    }
}
