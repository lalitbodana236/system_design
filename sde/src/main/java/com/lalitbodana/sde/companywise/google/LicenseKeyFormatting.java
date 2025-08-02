package com.lalitbodana.sde.companywise.google;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        int k = 4;
        //Output: "5F3Z-2E9W"
        System.out.println("5F3Z-2E9W".equals(licenseKeyFormatting(s, 4)));
        
        s = "2-5g-3-J";
        k = 2;
        //Output: "2-5G-3J"
        System.out.println("2-5G-3J".equals(licenseKeyFormatting(s, k)));
    }
    
    public static String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            count++;
            if (count == k && i != 0) {
                sb.append('-');
                count = 0;
            }
        }
        
        return sb.reverse().toString();
    }
}
