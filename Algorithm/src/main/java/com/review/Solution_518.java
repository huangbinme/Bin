package com.review;

public class Solution_518 {
    public int change(int amount, int[] coins) {
        //dp[i][j] ：用前i个硬币凑成金额为j的最多方式
        //dp[i][j] = dp[i-1][j] + (j - 第i个硬币的面值 >= 0 ? dp[i][j - 第i个硬币的面值] : 0)
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if(j - coins[i] >= 0){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
