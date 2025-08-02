package com.lalitbodana.sde.grind169;

public class ContainerWithMostWater {
    public static void main(String[] args) {
    
    }
    
    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int h1 = height[left];
            int h2 = height[right];
            
            int h = Math.min(h1, h2);
            
            int width = right - left;
            int area = h * width;
            
            max = Math.max(max, area);
            
            if (h1 < h2) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
    
}
