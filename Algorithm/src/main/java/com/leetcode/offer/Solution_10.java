package com.leetcode.offer;

public class Solution_10 {
    public int numWays(int n) {
        if (n <= 2) return n == 0 ? 1 : n;
        int mod = 1000000007;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n - 1];
    }
}
