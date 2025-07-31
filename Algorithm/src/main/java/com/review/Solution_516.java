package com.review;

public class Solution_516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp[0].length; i++) {
            int x = 0, y = i;
            while (x < dp.length && y < dp[0].length) {
                if (x == y) {
                    dp[x][y] = 1;
                } else {
                    int ans1 = dp[x + 1][y - 1] + (s.charAt(x) == s.charAt(y) ? 2 : 0);
                    int ans2 = Math.max(dp[x + 1][y], dp[x][y - 1]);
                    dp[x][y] = Math.max(ans1, ans2);
                }
                x++;
                y++;
            }
        }
        return dp[0][dp[0].length - 1];
    }
}
