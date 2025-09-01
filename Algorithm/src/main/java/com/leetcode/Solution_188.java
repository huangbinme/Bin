package com.leetcode;

public class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k * 2 + 1];
        for (int i = 1; i < dp[0].length; i += 2) {
            dp[0][i] = prices[0] * -1;
        }
        for (int i = 1; i < prices.length; i++) {
            int[] curDp = new int[dp[0].length], preDp = dp[i - 1];
            for (int j = 1; j < curDp.length; j++) {
                curDp[j] = Math.max(preDp[j], preDp[j - 1] + prices[i] * (j % 2 == 1 ? -1 : 1));
            }
            dp[i] = curDp;
        }
        int ans = 0;
        for (int i = 2; i < dp[0].length; i += 2) {
            ans = Math.max(ans, dp[dp.length - 1][i]);
        }
        return ans;
    }
}
