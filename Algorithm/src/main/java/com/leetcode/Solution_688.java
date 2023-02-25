package com.leetcode;

public class Solution_688 {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] around = {{1, 2}, {2, 1}, {1, -2}, {-1, 2}, {2, -1}, {-2, 1}, {-2, -1}, {-1, -2}};
        double[][] dp = new double[n][n];
        dp[row][column] = 1d;
        for (int i = 0; i < k; i++) {
            double[][] newDp = new double[n][n];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (dp[j][l] != 0) {
                        for (int m = 0; m < around.length; m++) {
                            int nextJ = j + around[m][0];
                            int nextL = l + around[m][1];
                            if (nextJ >= 0 && nextJ < n && nextL >= 0 && nextL < n) {
                                newDp[nextJ][nextL] += dp[j][l] / 8;
                            }
                        }
                    }
                }
            }
            dp = newDp;
        }
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
