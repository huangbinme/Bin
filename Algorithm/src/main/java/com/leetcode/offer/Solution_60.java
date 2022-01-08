package com.leetcode.offer;

public class Solution_60 {
    public double[] dicesProbability(int n) {
        double sum = Math.pow(6, n);
        int[][] dp = new int[n][6 * n];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int min = i + 1, max = (i + 1) * 6;
            for (int j = min; j <= max; j++) {
                int count = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j - k - 1 >= 0) {
                        count += dp[i - 1][j - k - 1];
                    }
                }
                dp[i][j - 1] = count;
            }
        }
        double[] ans = new double[5 * n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dp[dp.length - 1][i + n - 1] / sum;
        }
        return ans;
    }
}
