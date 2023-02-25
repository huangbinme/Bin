package com.leetcode;

import java.util.Arrays;

public class Solution_467 {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];
        dp[s.charAt(0) - 'a']++;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a', pre = s.charAt(i - 1) - 'a';
            if ((cur - 1 == pre) || (cur == 0 && pre == 25)) {
                dp[cur] = Math.max(dp[cur], count + 1);
                count++;
            }else {
                dp[cur] = Math.max(dp[cur], 1);
                count = 1;
            }
        }
        return Arrays.stream(dp).sum();
    }
}
