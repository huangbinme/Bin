package com.leetcode;

public class Solution_123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0] = new int[]{prices[0] * -1, 0, prices[0] * -1, 0};
        for (int i = 1; i < prices.length; i++) {
            int[] preDp = dp[i - 1];
            int price = prices[i];
            int p1 = Math.max(preDp[0], price * -1);
            int p2 = Math.max(preDp[1], preDp[0] + price);
            int p3 = Math.max(preDp[2], preDp[1] - price);
            int p4 = Math.max(preDp[3], preDp[2] + price);
            dp[i] = new int[]{p1, p2, p3, p4};
        }
        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][3]);
    }
}
