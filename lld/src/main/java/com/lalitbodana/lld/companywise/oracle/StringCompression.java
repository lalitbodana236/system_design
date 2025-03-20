package com.lalitbodana.lld.companywise.oracle;

public class StringCompression {
    public static void main(String[] args) {

    }


    public int compress(char[] chars) {
        int write = 0; // Write pointer
        int read = 0;  // Read pointer

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count occurrences of current character
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write character to the array
            chars[write++] = currentChar;

            // Write count if greater than 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write; // New length of the array
    }

}
