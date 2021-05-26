package com.solutions;

public class Solution_121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        if (prices.length == 2) return Math.max(prices[1] - prices[0], 0);
        return Math.max(find(prices), 0);
    }

    private int find(int[] prices) {
        int min = Math.min(prices[0], prices[1]);
        int maxPrice = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            maxPrice = Math.max(maxPrice, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxPrice;
    }
}
