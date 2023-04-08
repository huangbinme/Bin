package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] pair = new int[scores.length][2];
        for (int i = 0; i < pair.length; i++) {
            pair[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(pair, Comparator.<int[]>comparingInt(v -> v[0]).thenComparingInt(v -> v[1]));
        int[] dp = new int[pair.length];
        dp[0] = pair[0][0];
        int ans = dp[0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pair[j][1] <= pair[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += pair[i][0];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
