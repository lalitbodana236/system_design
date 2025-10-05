package com.lalitbodana.sde.ds.maths;

public class GCD {
    
    public static void main(String[] args) {
        System.out.println(gcdRec(15,25));
        System.out.println(gcd(15,25));
    }
    
    private static int gcdRec(int a,int b){
        if(b==0) return a;
        return gcdRec(b,a%b);
    }
    
    public static int gcd(int a,int b){
        while(b!=0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
