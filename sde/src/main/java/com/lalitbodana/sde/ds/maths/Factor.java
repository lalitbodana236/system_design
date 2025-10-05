package com.lalitbodana.sde.ds.maths;

public class Factor {
    public static void main(String[] args) {
        System.out.println(factor(36));
        System.out.println(factor(36));
        System.out.println(factorOpt1(16));
        System.out.println(factorOpt1(16));
        // 1,2,3,4,6,8,9,12,18,36
        // 1,2,4,8,16
    }
    
    
    private static int factor(int n){
        int count=0;
        for(int i =1 ; i<=n ; i++){
            if(n%i==0){
                if(i==n/i){
                    count+=1;
                }else{
                    count+=2;
                }
            }
        }
        
        return count;
    }
    
    private static int factorOpt1(int n){
        int count=0;
        for(int i =1 ; i*i<=n ; i++){
            if(n%i==0){
                if(i==n/i){
                    count+=1;
                }else{
                    count+=2;
                }
            }
        }
        
        return count;
    }
}
