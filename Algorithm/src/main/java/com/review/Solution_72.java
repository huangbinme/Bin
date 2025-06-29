package com.review;

public class Solution_72 {
    public int minDistance(String word1, String word2) {
        if(word1.isEmpty() || word2.isEmpty()) return Math.max(word1.length(), word2.length());
        int[][] dp = new int[word1.length()][word2.length()];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = word1.charAt(i) == word2.charAt(0) && dp[i - 1][0] == i ? dp[i - 1][0] : dp[i - 1][0] + 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = word1.charAt(0) == word2.charAt(i) && dp[0][i - 1] == i ? dp[0][i - 1] : dp[0][i - 1] + 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
