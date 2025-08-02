package com.lalitbodana.sde.backtracking;

public class FindThePunishmentNumberOfAnInteger {
    public static void main(String[] args) {
        //System.out.println("ans " + punishmentNumber(10));
        System.out.println("ans " + valid(100));
    }
    
    public static int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            
            if (valid(i * i) == i) {
                sum += i * i;
            }
        }
        
        return sum;
    }
    
    public static int valid(int n) {
        int sum = 0;
        int old = n;
        while (n > 0) {
            int rem = n % 10;
            
            sum = sum + rem;
            System.out.println(sum + " " + rem);
            
            n /= 10;
        }
        System.out.println(sum);
        return sum;
    }
}
