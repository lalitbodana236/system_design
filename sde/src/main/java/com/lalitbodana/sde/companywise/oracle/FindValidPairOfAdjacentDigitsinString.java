package com.lalitbodana.sde.companywise.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindValidPairOfAdjacentDigitsinString {
    public static void main(String[] args) {
        String s = "2523533";
        findValidPair(s);
        //  Output: "23"
    }

    public static String findValidPair(String s) {
        int[] freq = new int[10];
        StringBuilder sb = new StringBuilder();
        char[] cArr = s.toCharArray();
        for (char c : cArr) {
            freq[c - '0']++;
        }

        for (int i = 0; i < s.length(); i++) {
            int digit1 = s.charAt(i) - '0';
            int digit2 = s.charAt(i + 1) - '0';

            if (digit1 != digit2 && freq[digit1] == digit1 && freq[digit2] == digit2) {
                System.out.println(s + " " + i + " " + (i + 2));
                System.out.println(s.substring(i, i + 2));

                return s.substring(i, i + 2);
            }
        }

        return "";

    }

    public int compress(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        List list = new ArrayList();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        int index = 0;
        String s = "";
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            s += m.getKey() + m.getValue();
        }
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return list.size();
    }
}
