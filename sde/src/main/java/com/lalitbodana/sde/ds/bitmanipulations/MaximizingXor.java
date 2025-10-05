package com.lalitbodana.sde.ds.bitmanipulations;

public class MaximizingXor {
    public static void main(String[] args) {
       // System.out.println(maximizingXor(11,12));
        System.out.println(maximizingXor(10,15));
    }
    
    public static int maximizingXor(int l, int r) {
        int max=0;
        for(int i=l;i<=r;i++){
            for(int j=i;j<=r;j++){
                max = Math.max(max,i^j);
            }
        }
        
        return max;
        
    }
    
   
}
