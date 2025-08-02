package com.lalitbodana.resource.ds;

import java.util.ArrayList;

public class FindPrimeNumber {
    static ArrayList<Integer> primeRange(int M, int N) {
        ArrayList<Integer> list = new ArrayList();

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        return list;
    }

    private static boolean isPrime(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                count++;
                System.out.println(N / i);
                if (N / i != i) {
                    count++;
                }
            }
        }
        return count == 2;
    }

    public static void main(String[] args) {
        for (Integer i : primeRange(1, 10))
            System.out.print(i + " ");
    }
}
