package com.lalitbodana.sde.grind169;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }
    
    public static int reverse(int x) {
        long rev = 0;
        
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        
        if (rev > Integer.MIN_VALUE && rev < Integer.MAX_VALUE) {
            return (int) rev;
        }
        return 0;
    }
}
