package com.leetcode;

public class Solution_85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + (j - 1 >= 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int h = 1, l = dp[i][j];
                    while (i + 1 - h >= 0 && dp[i + 1 - h][j] > 0) {
                        l = Math.min(l, dp[i + 1 - h][j]);
                        int size = l * h;
                        ans = Math.max(ans, size);
                        h++;
                    }
                }
            }
        }
        return ans;
    }
}
