package com.lalitbodana.sde.ds.practice;

import java.util.Arrays;

public class MostProfitAssigningWork {
    
    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10}, profit = {10, 20, 30, 40, 50}, worker = {4, 5, 6, 7};
        //Output: 100
        
        System.out.println(new MostProfitAssigningWork().maxProfitAssignment(difficulty, profit, worker));
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Arrays.sort(difficulty);
        Arrays.sort(profit);
        int[] maxProfit = new int[profit.length];
        maxProfit[0] = profit[0];
        for (int i = 1; i < profit.length; i++) {
            maxProfit[i] = Math.max(maxProfit[i - 1], profit[i]);
        }
        
        Arrays.sort(worker);
        
        int ans = 0;
        int j = 0;
        for (int w : worker) {
            while (j < n && difficulty[j] <= w) {
                j++;
            }
            if (j > 0) {
                ans += maxProfit[j - 1];
            }
        }
        
        return ans;
    }
}
