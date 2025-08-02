package com.lalitbodana.resource.ds.assement;

public class NimGame {
    public static void main(String[] args) {
        canWinNim(4);
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
