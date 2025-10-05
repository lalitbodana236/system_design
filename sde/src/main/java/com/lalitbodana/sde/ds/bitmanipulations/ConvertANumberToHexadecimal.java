package com.lalitbodana.sde.ds.bitmanipulations;

import java.util.HashMap;
import java.util.Map;

public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        int num = 26;
        toHex(15);
        toHex(-1);
        
       // System.out.println(-1%16);
    }
    
    public static String toHex(int num){
        if (num == 0) return "0";
        
        char[] hexMap = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        
        while (num != 0) {
            int rem = num & 15; // same as num % 16 but always positive (0–15)
            System.out.println(rem);
            sb.append(hexMap[rem]);
            num >>>= 4; // divide by 16, unsigned shift
        }
        
        return sb.reverse().toString();
       
    }
}
