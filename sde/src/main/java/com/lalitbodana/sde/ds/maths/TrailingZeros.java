package com.lalitbodana.sde.ds.maths;

public class TrailingZeros {
    public static void main(String[] args) {
        System.out.println(trailingZeroInFactorial(10));
        System.out.println(trailingZeroInNumber(100));
    }
    
    public static int trailingZeroInFactorial(int n){
        int ans = 0;
        int divisor=5;
        while(divisor<=n){
            ans = ans + (n/divisor);
            
            divisor = divisor*5;
        }
        return ans;
    }
    
    public static int trailingZeroInNumber(int n) {
        int count = 0;
        while (n % 10 == 0 && n != 0) {
            count++;
            n /= 10;
        }
        return count;
    }
    
}
