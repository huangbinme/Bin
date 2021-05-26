package com.solutions;

import java.util.Arrays;

public class Solution_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] ints = format(strs);
        int[][][] dp = new int[strs.length][m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int max_0 = i;
                int max_1 = j;
                if (ints[0][0] <= max_0 && ints[0][1] <= max_1) {
                    dp[0][i][j] = 1;
                }
            }
        }

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0) {
                        continue;
                    }
                    dp[i][j][k] = dp[i - 1][j][k];
                    int a = dp[i][j][k];

                    int count_0 = ints[i][0];
                    int count_1 = ints[i][1];
                    int b = -1;
                    if (j - count_0 >= 0 && k - count_1 >= 0) {
                        b = dp[i - 1][j - count_0][k - count_1] + 1;
                    }
                    dp[i][j][k] = Math.max(a, b);
                }
            }
        }

        return dp[strs.length - 1][m][n];
    }

    public int[][] format(String[] strs) {
        int[][] ints = new int[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = format(strs[i]);
        }
        return ints;
    }

    public int[] format(String s) {
        String[] s1 = s.split("");
        int a = (int) Arrays.stream(s1).filter(k -> k.equals("0")).count();
        int b = (int) Arrays.stream(s1).filter(k -> k.equals("1")).count();
        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return result;
    }
}
