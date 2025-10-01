package com.lalitbodana.sde.ds.twopointer;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }
    
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        
        // 1. Total sum of all cards
        for (int point : cardPoints) {
            total += point;
        }
        
        // 2. Size of the window to be excluded = n - k
        int windowSize = n - k;
        int windowSum = 0;
        
        // 3. Initial window
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }
        
        int minWindowSum = windowSum;
        
        // 4. Slide the window
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }
        
        // 5. Max score = total - minimum sum of excluded window
        return total - minWindowSum;
    }
}
