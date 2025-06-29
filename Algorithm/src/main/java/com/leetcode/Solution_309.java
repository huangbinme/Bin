package com.leetcode;

public class Solution_309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0] = new int[]{prices[0] * -1, 0, 0};
        for (int i = 1; i < prices.length; i++) {
            //preY做了卖操作，preZ没做卖操作
            int preX = dp[i - 1][0], preY = dp[i - 1][1], preZ = dp[i - 1][2];
            int x = Math.max(preX, preZ - prices[i]);
            int y = preX + prices[i];
            int z = Math.max(preY, preZ);
            dp[i] = new int[]{x, y, z};
        }
        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][2]);
    }
}
