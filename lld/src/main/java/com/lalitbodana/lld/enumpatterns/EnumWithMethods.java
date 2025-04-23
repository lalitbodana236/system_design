package com.lalitbodana.lld.enumpatterns;

public class EnumWithMethods {
    public static void main(String[] args) {
        Status s = Status.SUCCESS;
        System.out.println(s + " Code: " + s.getCode());
        
        
        for (Status d : Status.values()) {
            System.out.println(d + " at index " + d.ordinal());
        }
        
        // Converting String to Enum
        Status day = Status.valueOf("success");
        System.out.println("Converted from String: " + day);
    }
    
}
