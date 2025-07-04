package com.review;

public class Solution_122 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            ans += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0;
        }
        return ans;
    }
}
