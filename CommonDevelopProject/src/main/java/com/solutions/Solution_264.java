package com.solutions;

public class Solution_264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int p2_num = dp[p2] * 2;
            int p3_num = dp[p3] * 3;
            int p5_num = dp[p5] * 5;
            dp[i] = Math.min(Math.min(p2_num, p3_num), p5_num);
            if (dp[i] == p2_num) p2++;
            if (dp[i] == p3_num) p3++;
            if (dp[i] == p5_num) p5++;
        }
        return dp[dp.length - 1];
    }
}
