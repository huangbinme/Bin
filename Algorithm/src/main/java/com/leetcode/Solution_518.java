package com.leetcode;

public class Solution_518 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (i == 0) {
                        dp[i][j] = j % coins[i] == 0 ? 1 : 0;
                    } else {
                        for (int k = j; k >= 0; k -= coins[i]) {
                            dp[i][j] += dp[i - 1][k];
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
