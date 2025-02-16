package com.lalitbodana.lld.ds.bitmanipulations;

public class DecimalToBinary {
    public static void main(String[] args) {
        convert(43261596);
    }

    public static void convert(int decimal) {
        //String binaryStr = Integer.toBinaryString(decimal);
        //decimal=~decimal;
        //  System.out.println(decimal);
        // decimal+=1;

        // System.out.println("00000010100101000001111010011100");
        StringBuffer binary = new StringBuffer();
        while (decimal > 0) {
            binary.append(decimal % 2);
            decimal /= 2;
        }
        BinaryToDecimal.convert(binary.toString());
        System.out.println(binary);
    }
}
