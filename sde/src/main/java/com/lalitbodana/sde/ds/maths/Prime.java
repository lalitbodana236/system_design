package com.lalitbodana.sde.ds.maths;

public class Prime {
    
    public static void main(String[] args) {
    
    }
    
    private static boolean isPrime (int n){
        
        for(int i=2;i<n;i++){
            if(n%i==0)
                return false;
        }
        
        return true;
    }
    
    private static boolean isPrimeOpt1 (int n){
        if (n <= 1) return false;  // 0 and 1 are not prime
        if (n == 2) return true;   // 2 is the only even prime
        if (n % 2 == 0) return false; // eliminate other even numbers
        
        // check only odd divisors up to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        
        return true;
    }
}
