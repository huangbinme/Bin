package com.leetcode;

public class Solution_64 {
    public int minPathSum(int[][] grid) {
        return dp(grid);
    }

    public int dp(int[][] grid) {
        int k = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[k][j];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < k; i++) {
            for (int l = 0; l < j; l++) {
                if (i == 0 && l == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][l] = dp[i][l - 1] + grid[i][l];
                    continue;
                }
                if (l == 0) {
                    dp[i][l] = dp[i - 1][l] + grid[i][l];
                    continue;
                }
                dp[i][l] = Math.min(dp[i - 1][l], dp[i][l - 1]) + grid[i][l];
            }
        }
        return dp[k - 1][j - 1];
    }
}
