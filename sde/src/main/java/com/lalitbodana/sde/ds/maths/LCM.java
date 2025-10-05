package com.lalitbodana.sde.ds.maths;

public class LCM {
    public static void main(String[] args) {
        System.out.println(lcm(15,25));
        System.out.println(lcm(5,35));
    }
    
    private static int lcm(int a,int b){
        return (a * b) / GCD.gcd(a, b);
    }
}
