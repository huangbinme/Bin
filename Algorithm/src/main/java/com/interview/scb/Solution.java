package com.interview.scb;

import java.util.List;

public class Solution {
    public static int minNum(int threshold, List<Integer> points) {
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[points.size()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int sub = dp[i - 1] + 1;
            if (i - 2 >= 0) sub = Math.min(sub, dp[i - 2] + 1);
            dp[i] = sub;
            if (points.get(i) - points.get(0) >= threshold) {
                ans = Math.min(ans, dp[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? points.size() : ans;
    }
}
