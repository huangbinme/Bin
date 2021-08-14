package com.leetcode;

public class Solution_516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int x = 0, y = i;
            while (x < s.length() && y < s.length()) {
                if (x == y) {
                    dp[x][y] = 1;
                } else {
                    dp[x][y] = s.charAt(x) == s.charAt(y) ? dp[x + 1][y - 1] + 2 : Math.max(dp[x + 1][y], dp[x][y - 1]);
                }
                x++;
                y++;
            }
        }
        return dp[0][s.length() - 1];
    }
}
