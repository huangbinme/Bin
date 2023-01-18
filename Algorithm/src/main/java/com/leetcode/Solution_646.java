package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_646 {
    public int findLongestChain(int[][] pairs) {
        //Sorting by second number, because it allows us to achieve greater link length
        Arrays.sort(pairs, Comparator.comparingInt(v -> v[1]));
        int[][] dp = new int[pairs.length][];
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = new int[]{1, pairs[i][1]};
        }
        int ans = 1;
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j][1] < pairs[i][0]) {
                    dp[j][0]++;
                    dp[j][1] = pairs[i][1];
                    ans = Math.max(ans, dp[j][0]);
                }
            }
        }
        return ans;
    }
}
