package com.lalitbodana.sde.ds.bitmanipulations;

public class DecimalToBinary {
    public static void main(String[] args) {
        convert(43261596);
        convert(5);
    }

    public static void convert(long decimal) {
        StringBuffer binary = new StringBuffer();
        while (decimal > 0) {
            binary.append(decimal % 2);
            decimal /= 2;
        }
        System.out.println(binary);
    }
}
