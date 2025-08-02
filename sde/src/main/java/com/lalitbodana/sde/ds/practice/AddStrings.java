package com.lalitbodana.sde.ds.practice;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
        System.out.println(addStrings("456", "77"));
        System.out.println(addStrings("0", "0"));
        //134
        //"533"
        //0
    }
    
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int ch1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int ch2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            // System.out.println(ch1 + ch2);
            int sum = ch1 + ch2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
            
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
    
    public int reverse(int x) {
        long rev = 0;
        
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        
        if (rev > Integer.MIN_VALUE && rev < Integer.MAX_VALUE)
            return (int) rev;
        
        return 0;
        
    }
}
