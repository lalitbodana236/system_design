package com.lalitbodana.sde.ds.assement;

public class HammingDistanct {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;  // XOR operation
        int count = 0;

        while (xor > 0) {
            count += (xor & 1); // Check if the last bit is 1
            System.out.println(count + " " + xor);
            xor = xor >> 1;     // Right shift to check the next bit
        }

        return count;
    }


}
