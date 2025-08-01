package com.review;

public class Solution_64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + grid[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
