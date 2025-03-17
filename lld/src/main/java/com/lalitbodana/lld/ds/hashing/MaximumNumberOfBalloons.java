package com.lalitbodana.lld.ds.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    public static void main(String[] args) {
        String text = "nlaebolko";

        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {
        int min = Integer.MAX_VALUE;

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        String str = "balon"; // balloon
        for (char ch : text.toCharArray()) {
            if (str.contains(Character.toString(ch))) {
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
            }
        }

        for (char ch : str.toCharArray()) {

            int count = map.getOrDefault(ch, 0);
            if (ch == 'l' || ch == 'o') {
                count /= 2;
            }
            min = Math.min(count, min);
        }


        System.out.println(map);
        System.out.println(map1);
        return min;
    }
}
