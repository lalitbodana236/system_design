package com.lalitbodana.sde.ds.bitmanipulations;

public class FindSetBit {
    public static void main(String[] args) {
        System.out.println(isBitSet(5,2));
    }
    
    public static boolean isBitSet(int num,int k){
        return  (num & (1 << k)) == 1 ;
        
        
    }

    
}
