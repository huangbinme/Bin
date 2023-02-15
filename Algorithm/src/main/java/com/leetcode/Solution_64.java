package com.leetcode;

public class Solution_64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) continue;
                int top = inbound(grid, i - 1, j) ? dp[i - 1][j] : Integer.MAX_VALUE;
                int left = inbound(grid, i, j - 1) ? dp[i][j - 1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(top, left) + grid[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private boolean inbound(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
