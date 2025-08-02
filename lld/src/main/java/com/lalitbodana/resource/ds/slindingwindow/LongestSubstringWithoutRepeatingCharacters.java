package com.lalitbodana.resource.ds.slindingwindow;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        // char c = 'a';
        //System.out.println((int)c-'a');
        lengthOfLongestSubstringOptimal("abcabcbb");
    }


    public static int lengthOfLongestSubstringOptimal(String s) {
        if (s.length() == 0) return 0;
        int max = Integer.MIN_VALUE;
        char[] c = s.toCharArray();

        int l = 0;
        int r = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        while (r < c.length) {
            if (hash[c[r]] != -1) {
                if (hash[c[r]] >= l) {
                    l = hash[c[r]] + 1;
                }
            }
            max = Math.max(max, r - l + 1);
            hash[c[r]] = r;

            r++;
        }
        return max;
    }

    public int lengthOfLongestSubstringBruteFroce(String s) {
        if (s.length() == 0) return 0;
        int max = Integer.MIN_VALUE;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int[] hash = new int[256];
            Arrays.fill(hash, -1);
            for (int j = i; j < c.length; j++) {
                if (hash[c[j]] != -1)
                    break;
                max = Math.max(max, j - i + 1);
                hash[c[j]] = 1;

            }
        }
        return max;
    }
}
