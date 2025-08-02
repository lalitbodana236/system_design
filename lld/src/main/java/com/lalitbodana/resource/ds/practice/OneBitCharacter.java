package com.lalitbodana.resource.ds.practice;

public class OneBitCharacter {
    
    public static void main(String[] args) {
        System.out.println(new OneBitCharacter().isOneBitCharacter(new int[]{1, 0, 0}));
    }
    
    public void isOneBitCharacterConvert(int[] bits) {
        int result = 0;
        int power = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] > 0) {
                result += Math.pow(2, power);
            }
            power++;
        }
        
        
    }
    
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2; // two-bit character
            } else {
                i += 1; // one-bit character
            }
        }
        // If we land exactly on the last character, it must be a one-bit character
        return i == bits.length - 1;
    }
    
}
