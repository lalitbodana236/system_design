package com.lalitbodana.lld.Blind75;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        for (int i : dailyTemperatures(temperatures))
            System.out.print(i + " ");
        System.out.println();
        temperatures = new int[]{30, 40, 50, 60};
        for (int i : dailyTemperatures(temperatures))
            System.out.print(i + " ");
        temperatures = new int[]{55, 38, 53, 81, 61, 93, 97, 32, 43, 78};
        System.out.println();
        for (int i : dailyTemperatures(temperatures))
            System.out.print(i + " ");
    }
    
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int index = 0;
        
        int left = 0;
        int right = 0;
        
        int dayCount = 0;
        while (left < n) {
            
            if (right >= n) {
                ans[index] = 0;
                index++;
                left++;
                dayCount = 0;
                right = left;
                
                continue;
            }
            
            if (temperatures[right] > temperatures[left]) {
                ans[index] = dayCount;
                index++;
                left++;
                dayCount = 0;
                right = left;
                //   right++;
                continue;
                
            }
            dayCount++;
            right++;
        }
        
        return ans;
    }
}
