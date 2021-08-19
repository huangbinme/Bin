package com.leetcode;

import java.util.Arrays;

public class Solution_576 {
    int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] cache = new int[m][n][maxMove];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] ints = new int[maxMove + 1];
                Arrays.fill(ints, -1);
                cache[i][j] = ints;
            }
        }
        return dfs(m, n, maxMove, startRow, startColumn, 0, cache);
    }

    private int dfs(int m, int n, int maxMove, int curM, int curN, int moveCount, int[][][] cache) {
        if (outBound(m, n, curM, curN)) return 1;
        if (moveCount == maxMove) return 0;
        if (cache[curM][curN][moveCount] != -1) return cache[curM][curN][moveCount];
        int sub = 0;
        sub = (dfs(m, n, maxMove, curM - 1, curN, moveCount + 1, cache) + sub) % mod;
        sub = (dfs(m, n, maxMove, curM, curN - 1, moveCount + 1, cache) + sub) % mod;
        sub = (dfs(m, n, maxMove, curM + 1, curN, moveCount + 1, cache) + sub) % mod;
        sub = (dfs(m, n, maxMove, curM, curN + 1, moveCount + 1, cache) + sub) % mod;
        cache[curM][curN][moveCount] = sub;
        return sub;
    }

    private boolean outBound(int m, int n, int curM, int curN) {
        return !(curM >= 0 && curM < m && curN >= 0 && curN < n);
    }
}
