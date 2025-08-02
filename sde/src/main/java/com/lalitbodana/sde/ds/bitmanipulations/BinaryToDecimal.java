package com.lalitbodana.sde.ds.bitmanipulations;

public class BinaryToDecimal {


    public static void main(String[] args) {

        String binary = "101011"; // Binary number as a string
        // String.format("%D",binary,32);
        String.format("%d,32", binary);
        convert(binary);
    }

    public static void convert(String binary) {

        //int decimal = Integer.parseInt(binary, 2);
        //System.out.println(decimal);

        int decimal = 0;


        for (int i = 0; i < binary.length(); i++) {

            int bit = binary.charAt(binary.length() - 1 - i) - '0';

            decimal += bit * Math.pow(2, i);
        }

        System.out.println("The decimal equivalent of binary " + binary + " is: " + decimal);
    }


}
