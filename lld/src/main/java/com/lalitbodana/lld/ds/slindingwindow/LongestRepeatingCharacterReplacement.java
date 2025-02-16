package com.lalitbodana.lld.ds.slindingwindow;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        //Output: 4

        System.out.println(characterReplacementOptimal("ABAB", 2));
        System.out.println(characterReplacementOptimal("AABABBA", 1));
        System.out.println(characterReplacementOptimal("ABBB", 2));
    }

    public static int characterReplacementOptimal(String s, int k) {
        int max = 0;
        char[] cArr = s.toCharArray();
        int maxFeq = 0;
        int r = 0;
        int l = 0;
        int[] hash = new int[26];
        Arrays.fill(hash, 0);
        while (r < s.length()) {
            hash[cArr[r] - 'A']++;
            maxFeq = Math.max(maxFeq, hash[cArr[r] - 'A']);
            while ((r - l + 1) - maxFeq > k) {
                hash[cArr[l] - 'A']--;
                maxFeq = 0;
                for (int i = 0; i < hash.length; i++) {
                    maxFeq = Math.max(maxFeq, hash[i]);
                    l++;
                }
            }
            if ((r - l + 1) - maxFeq <= k) {
                max = Math.max(max, r - l + 1);
            }
            r++;
        }
        return max;
    }

    public static int characterReplacementBruteFroce(String s, int k) {
        int max = 0;
        char[] cArr = s.toCharArray();
        int maxFeq = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[26];
            Arrays.fill(hash, 0);

            for (int j = i; j < s.length(); j++) {
                hash[cArr[j] - 'A']++;
                maxFeq = Math.max(maxFeq, hash[cArr[j] - 'A']);
                int change = (j - i + 1) - maxFeq;

                if (change <= k) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
