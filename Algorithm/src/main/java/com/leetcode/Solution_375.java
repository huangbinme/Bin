package com.leetcode;

public class Solution_375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int j = 1, k = i;
            while (j <= n && k <= n) {
                if (j != k) {
                    int res = Integer.MAX_VALUE;
                    for (int l = j; l <= k; l++) {
                        int curRes = 0;
                        if (l == j) {
                            curRes = l + dp[j + 1][k];
                        } else if (l == k) {
                            curRes = l + dp[j][k - 1];
                        } else {
                            curRes = l + Math.max(dp[j][l - 1], dp[l + 1][k]);
                        }
                        res = Math.min(res, curRes);
                    }
                    dp[j][k] = res;
                }
                j++;
                k++;
            }
        }
        return dp[1][dp[0].length - 1];
    }
}
