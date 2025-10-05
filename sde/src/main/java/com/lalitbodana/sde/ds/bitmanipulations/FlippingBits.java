package com.lalitbodana.sde.ds.bitmanipulations;

public class FlippingBits {
    public static void main(String[] args) {
        System.out.println(flippingBits(9));
        System.out.println(flippingBitsOpt1(9));
        System.out.println(flippingBitsOpt2(9));
        
    }
    
    public static long flippingBits(long n) {
        return (~n) & 0xFFFFFFFFL;
    }
    
    public static long flippingBitsOpt1(long n) {
        // Maximum value of 32-bit unsigned integer
        long maxUnsignedInt = 4294967295L;
        // Subtract the number from max to flip all bits
        return maxUnsignedInt - (long)n;
    }
    
    public static long flippingBitsOpt2(long n) {
        // Convert number to 32-bit binary string
        String binary = String.format("%32s", Long.toBinaryString(n));
        binary = binary.replace(' ', '0');
        System.out.println("Original (binary): " + binary);
        
        // Flip each bit
        StringBuilder flippedBinary = new StringBuilder();
        for (char c : binary.toCharArray()) {
            flippedBinary.append(c == '0' ? '1' : '0');
        }
        System.out.println("Flipped  (binary): " + flippedBinary);
        
        // Convert flipped binary string back to long
        return Long.parseLong(flippedBinary.toString(), 2);
    }
}
