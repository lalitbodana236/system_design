package com.lalitbodana.lld.grind169;

import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {
    
    public static void main(String[] args) {
        for (int i : sieveOfEratosthenes(50)) {
            System.out.print(i + " ");
        }
    }
    
    static ArrayList<Integer> sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    
                    
                    prime[j] = false;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (prime[i]) {
                ans.add(i);
            }
        }
        
        return ans;
        
    }
}
