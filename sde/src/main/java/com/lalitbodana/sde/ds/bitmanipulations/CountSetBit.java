package com.lalitbodana.sde.ds.bitmanipulations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountSetBit {
    public static void main(String[] args) {
       // System.out.println(countPrimeSetBits(6,10));
        System.out.println(countPrimeSetBits(10,15));
     //   System.out.println(countPrimeSetBits(7));
    }
    
    public static int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i = left;i<=right;i++){
            int num = countSetBit(i);
            if(isPrime(num)){
                count++;
            }
        }
        return count;
    }
    
    private static int countSetBit(int num){
        int count=0;
        while(num!=0){
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
    
    private static final Set<Integer> primes =
            new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19));
    
    private static boolean isPrime(int num){
        return primes.contains(num);
    }
    
    
    
}
