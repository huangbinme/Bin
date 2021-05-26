package com.leetcode;

public class Solution_122 {

    public int maxProfitDp(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        if (prices.length == 2) return Math.max(0, prices[1] - prices[0]);

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[dp.length - 1][0];
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        if (prices.length == 2) return Math.max(0, prices[1] - prices[0]);
        int result = 0;
        int min = Math.min(prices[0], prices[1]);
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
                continue;
            }

            if (i == prices.length - 1) {
                result += prices[i] - min;
                continue;
            }

            if (prices[i] <= prices[i + 1]) {
                continue;
            } else {
                result += prices[i] - min;
                min = prices[i + 1];
            }
        }
        return result;
    }
}
