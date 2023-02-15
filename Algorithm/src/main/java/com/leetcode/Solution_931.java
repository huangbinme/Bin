package com.leetcode;

import java.util.Arrays;

public class Solution_931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num1 = validate(i - 1, j - 1, n) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int num2 = validate(i - 1, j, n) ? dp[i - 1][j] : Integer.MAX_VALUE;
                int num3 = validate(i - 1, j + 1, n) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                int min = Math.min(num1, Math.min(num2, num3));
                dp[i][j] = min == Integer.MAX_VALUE ? matrix[i][j] : min + matrix[i][j];
            }
        }
        return Arrays.stream(dp[n-1]).min().getAsInt();
    }

    private boolean validate(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
