package com.leetcode;

public class Solution_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] indexes = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < indexes.length; j++) {
                dp[i] = Math.min(dp[i], dp[indexes[j]] * primes[j]);
            }
            for (int j = 0; j < indexes.length; j++) {
                if (dp[indexes[j]] * primes[j] == dp[i]) {
                    indexes[j]++;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
