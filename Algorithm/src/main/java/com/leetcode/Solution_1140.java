package com.leetcode;

public class Solution_1140 {
    public int stoneGameII(int[] piles) {
        int[][] dp = new int[piles.length + 1][piles.length];
        int sum = 0;
        for (int j = dp[0].length - 1; j >= 0; j--) {
            sum += piles[j];
            for (int i = 1; i < dp.length; i++) {
                if (j + i * 2 >= dp[0].length) {
                    dp[i][j] = sum;
                } else {
                    for (int k = j; k <= j + i * 2 - 1; k++) {
                        dp[i][j] = Math.max(dp[i][j], sum - dp[Math.max(k - j + 1, i)][k + 1]);
                    }
                }
            }
        }
        return dp[1][0];
    }
}
