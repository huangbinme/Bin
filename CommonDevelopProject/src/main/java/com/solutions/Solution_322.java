package com.solutions;

public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] dp = new int[amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            if(coins[i]==1){
                dp[1] = 1;
                break;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if(i==0||i==1){
                continue;
            }

            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j]>=0){
                    if(dp[i-coins[j]]==0){
                        dp[i] = 1;
                    }else if(dp[i-coins[j]]>0) {
                        dp[i] = dp[i]==-1?dp[i-coins[j]]+1: Math.min(dp[i-coins[j]]+1,dp[i]);
                    }
                }
            }
        }

        return dp[dp.length-1];
    }
}
