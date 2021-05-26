package com.solutions;

public class Solution_5728 {
    int LIMIT;

    public int minSideJumps(int[] obstacles) {
        LIMIT = obstacles.length * 2;
        int[][] dp = new int[obstacles.length][3];
        dp(obstacles, dp);
        return getMin(dp[dp.length - 1][0], dp[dp.length - 1][1], dp[dp.length - 1][2]);
    }

    private void dp(int[] obstacles, int[][] dp) {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 1;
        for (int i = 1; i < obstacles.length; i++) {
            if (obstacles[i] > 0) dp[i][obstacles[i] - 1] = LIMIT;
            int a = dp[i - 1][0];
            int b = dp[i - 1][1];
            int c = dp[i - 1][2];
            if (obstacles[i] != 1) {
                int fromA = dp[i - 1][0] != LIMIT ? a : LIMIT;
                int fromB = dp[i - 1][1] != LIMIT && obstacles[i] != 2 ? b + 1 : LIMIT;
                int fromC = dp[i - 1][2] != LIMIT && obstacles[i] != 3 ? c + 1 : LIMIT;
                dp[i][0] = getMin(fromA, fromB, fromC);
            }
            if (obstacles[i] != 2) {
                int fromA = dp[i - 1][0] != LIMIT && obstacles[i] != 1 ? a + 1 : LIMIT;
                int fromB = dp[i - 1][1] != LIMIT ? b : Integer.MAX_VALUE;
                int fromC = dp[i - 1][2] != LIMIT && obstacles[i] != 3 ? c + 1 : LIMIT;
                dp[i][1] = getMin(fromA, fromB, fromC);
            }

            if (obstacles[i] != 3) {
                int fromA = dp[i - 1][0] != LIMIT && obstacles[i] != 1 ? a + 1 : LIMIT;
                int fromB = dp[i - 1][1] != LIMIT && obstacles[i] != 2 ? b + 1 : LIMIT;
                int fromC = dp[i - 1][2] != LIMIT ? c : LIMIT;
                dp[i][2] = getMin(fromA, fromB, fromC);
            }
        }
    }

    private int getMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
