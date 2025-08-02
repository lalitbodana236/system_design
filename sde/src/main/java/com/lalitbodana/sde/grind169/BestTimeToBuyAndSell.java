package com.lalitbodana.sde.grind169;

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else
                maxProfit = Math.max(prices[i] - buy, maxProfit);


        }

        return maxProfit;
    }
}
