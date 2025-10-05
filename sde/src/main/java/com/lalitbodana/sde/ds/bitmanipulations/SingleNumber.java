package com.lalitbodana.sde.ds.bitmanipulations;

public class SingleNumber {
    
    
    public static int number(int[] arr){
        int n=0;
        
        for(int i=0;i<arr.length;i++){
            n=n^arr[i];
        }
        
        return n;
    }
}
