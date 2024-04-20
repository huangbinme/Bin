package com.leetcode;

import java.util.Arrays;

public class Solution_1883 {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        if (dist.length == 1) return Math.ceil((double) dist[0] / speed) <= hoursBefore ? 0 : -1;
        double k = 0.000000001;
        double[][] dp = new double[dist.length][dist.length];
        Arrays.fill(dp[0], 2000000);
        for (int i = 0; i < dist.length; i++) {
            dp[i][0] = Math.ceil((double) dist[i] / speed) + (i == 0 ? 0 : dp[i - 1][0]);
        }
        dp[0][1] = (double) dist[0] / speed;
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist.length; j++) {
                if (i == dist.length - 1) {
                    double d1 = (double) dist[i] / speed + dp[i - 1][j - 1] - k;
                    double d2 = (double) dist[i] / speed + dp[i - 1][j] - k;
                    dp[i][j] = Math.min(d1, d2);
                } else {
                    double skip = (double) dist[i] / speed + dp[i - 1][j - 1] - k;
                    double nonSkip = Math.ceil((double) dist[i] / speed + dp[i - 1][j] - k);
                    dp[i][j] = Math.min(skip, nonSkip);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[dp.length - 1][i] <= hoursBefore) {
                return i;
            }
        }
        return -1;
    }
}
