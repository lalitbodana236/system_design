package com.lalitbodana.resource.ds.recursion;

public class KthCharacterInStringGame {
    public static void main(String[] args) {
        int k1 = 5;
        System.out.println(findKthChar(k1)); // Output: "b"

        int k2 = 10;
        // System.out.println(findKthChar(k2)); // Output: "c"
    }

    public static char findKthCharacter(int k) {
        String word = "a";

        while (word.length() < k) {
            word = word + shiftCharacters(word);
        }

        return word.charAt(k - 1);
    }

    private static String shiftCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append((char) (c + 1));
        }
        return sb.toString();
    }


    public static char findKthChar(int k) {
        return findKthRecursive("a", k);
    }

    private static char findKthRecursive(String current, int k) {
        if (current.length() >= k) {
            return current.charAt(k - 1);
        }

        String next = current + shiftCharacters(current);
        return findKthRecursive(next, k);
    }

}
