package com.leetcode;

public class Solution_115 {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            char curC = s.charAt(i);
            for (int j = t.length() - 1; j >= 0; j--) {
                if (curC == t.charAt(j)) {
                    if (j - 1 >= 0) {
                        dp[j] += dp[j - 1];
                    } else {
                        dp[j]++;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
