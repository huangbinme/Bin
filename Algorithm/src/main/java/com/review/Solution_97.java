package com.review;

public class Solution_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] == 1 && s2.charAt(i - 1) == s3.charAt(i - 1) ? 1 : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] == 1 && s1.charAt(i - 1) == s3.charAt(i - 1) ? 1 : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char curC = s3.charAt(i + j - 1);
                int x = curC == s2.charAt(j - 1) && dp[i][j - 1] == 1 ? 1 : 0;
                int y = curC == s1.charAt(i - 1) && dp[i - 1][j] == 1 ? 1 : 0;
                dp[i][j] = Math.max(x, y);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1] == 1;
    }
}
