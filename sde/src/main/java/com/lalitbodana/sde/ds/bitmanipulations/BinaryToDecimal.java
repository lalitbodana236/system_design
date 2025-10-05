package com.lalitbodana.sde.ds.bitmanipulations;

public class BinaryToDecimal {


    public static void main(String[] args) {
        convert("101011");
        convert("101");
        
        System.out.println(pow(2, 2));
    }

    public static void convert(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            int bit = binary.charAt(binary.length() - 1 - i) - '0';
           // decimal += bit * Math.pow(2, i);
            decimal += bit * pow(2, i);
        }
        System.out.println("The decimal equivalent of binary " + binary + " is: " + decimal);
    }
    
    public static int pow(int pow,int val){
        int ans=1;
        for(int i=0;i<val;i++){
            ans*=pow;
        }
        return ans;
    }


}
