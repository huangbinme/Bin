package com.review;

public class Solution_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            int k = 1;
            dp[i] = Integer.MAX_VALUE;
            while (i - k * k >= 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i - k * k]);
                k++;
            }
        }
        return dp[dp.length - 1];
    }
}
