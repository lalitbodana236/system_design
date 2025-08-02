package com.lalitbodana.sde.ds.hashing;

import java.util.HashSet;

public class FairCandySwap {
    public static void main(String[] args) {
        int[] aliceSizes = {1, 1}, bobSizes = {2, 2};
        for (int i : fairCandySwap(aliceSizes, bobSizes)) {
            System.out.print(i + " ");
        }
    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aSum = 0, bSum = 0;
        for (int i : aliceSizes)
            aSum += i;

        for (int i : bobSizes)
            bSum += i;

        int ans = (aSum - bSum) / 2;

        HashSet<Integer> set = new HashSet<>();
        for (int num : bobSizes) {
            set.add(num);
        }

        for (int x : aliceSizes) {
            int y = x - ans;
            if (set.contains(y)) {
                return new int[]{x, y};
            }
        }

        return new int[]{-1, -1};


    }
}
