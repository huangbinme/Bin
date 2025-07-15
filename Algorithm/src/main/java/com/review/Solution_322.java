package com.review;

public class Solution_322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] == 0) {
                    ans = 1;
                    break;
                } else if (i - coins[j] > 0 && dp[i - coins[j]] > 0) {
                    ans = Math.min(ans, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = ans == Integer.MAX_VALUE ? 0 : ans;
        }
        return dp[dp.length - 1] == 0 ? -1 : dp[dp.length - 1];
    }
}
