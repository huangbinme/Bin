package com.leetcode;

import java.util.List;

public class Solution_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int a = triangle.size() + 1;
        int b = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[a][b];

        dp[1][0] = triangle.get(0).get(0);
        for (int i = 2; i < a; i++) {
            for (int j = 0; j < b && j < i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle.get(i - 1).get(0);
                    continue;
                }

                if (j == i - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i - 1).get(j);
                    continue;
                }

                dp[i][j] = triangle.get(i - 1).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }

        int result = dp[a - 1][0];
        for (int i = 0; i < dp[a - 1].length; i++) {
            result = Math.min(result, dp[a - 1][i]);
        }
        return result;
    }
}
