package com.lalitbodana.sde.ds.bitmanipulations;

public class DivideTwoIntegers {
    
    public static void main(String[] args) {
        System.out.println(divide(10,3));
    }
    
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        
        
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }
        
        
        int quotient=0;
        
        while (dividend - divisor <= 0) {
            quotient--;
            dividend -= divisor;
            
        }
        
        if (negatives != 1) {
            quotient = -quotient;
        }
        return quotient;
    }
}
