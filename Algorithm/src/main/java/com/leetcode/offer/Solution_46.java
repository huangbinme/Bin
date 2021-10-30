package com.leetcode.offer;

public class Solution_46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            dp[i] = dp[i - 1];
            int newNum = str.charAt(i) - '0' + (str.charAt(i - 1) - '0') * 10;
            if (newNum >= 10 && newNum <= 25) dp[i] += (i == 1 ? 1 : dp[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
