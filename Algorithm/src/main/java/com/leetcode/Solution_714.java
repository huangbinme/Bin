package com.leetcode;

public class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int hasStock = (prices[0] + fee) * -1, noStock = 0;
        for (int i = 1; i < prices.length; i++) {
            int newNoStock = Math.max(noStock, prices[i] + hasStock);
            int newHasStock = Math.max(hasStock, noStock - (prices[i] + fee));
            hasStock = newHasStock;
            noStock = newNoStock;
        }
        return noStock;
    }
}
