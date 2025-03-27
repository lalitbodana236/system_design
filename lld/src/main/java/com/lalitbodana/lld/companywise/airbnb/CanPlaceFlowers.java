package com.lalitbodana.lld.companywise.airbnb;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));


        System.out.println(canPlaceFlowers(flowerbed, 2));

        int[] arr = {1, 0, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(arr, 2));

        int[] arr1 = {0, 0, 1, 0, 1};
        System.out.println(canPlaceFlowers(arr1, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = 0;
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = i == 0 || flowerbed[i - 1] == 0;
                boolean rightEmpty = i == len - 1 || flowerbed[i + 1] == 0;

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n)
                        return true;
                }
            }
        }
        return count >= n;
    }
}
