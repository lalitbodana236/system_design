package com.lalitbodana.resource.ds.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class DecodeTheMessage {
    public static void main(String[] args) {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
    
    public static String decodeMessage(String key, String message) {
        System.out.println(key.length() - 8);
        int idx = 0;
        Map<Character, Character> map = new LinkedHashMap<>();
        for (char c : key.toCharArray()) {
            if (c != ' ' && !map.containsKey(c)) {
                map.putIfAbsent(c, (char) (idx + 'a'));
                idx++;
            }
            
        }
        
        for (Map.Entry<Character, Character> m : map.entrySet()) {
            
            System.out.println(m.getKey() + " : " + m.getValue());
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else if (c == ' ') {
                sb.append(" ");
            }
        }
        
        return sb.toString();
        
    }
}
