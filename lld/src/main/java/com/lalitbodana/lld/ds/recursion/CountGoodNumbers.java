package com.lalitbodana.lld.ds.recursion;

public class CountGoodNumbers {

    public static void main(String[] args) {
        generateNumbers(new StringBuilder(), 0, 1);
    }

    private static void generateNumbers(StringBuilder num, int length, int n) {
        if (length == 9) {
            System.out.println(num.toString()); // Print the number when 10 digits are reached
            return;
        }
        for (int i = 0; i < n; i++) { // Loop through 0-9
            num.append(i);              // Append current digit
            generateNumbers(num, length + 1, n); // Recursive call
            num.deleteCharAt(num.length() - 1); // Backtrack to remove last digit
        }
    }
}
