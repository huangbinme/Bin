package com.review;

public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        boolean[][] visit = new boolean[n][n];
        dfs(ans, visit, n, 0, 0, 1);
        return ans;
    }

    private void dfs(int[][] ans, boolean[][] visit, int n, int i, int j, int num) {
        if (!inbound(n, i, j) || visit[i][j]) return;
        ans[i][j] = num;
        visit[i][j] = true;
        if (!inbound(n, i - 1, j) || visit[i-1][j]) {
            dfs(ans, visit, n, i, j + 1, num + 1);
        }
        dfs(ans, visit, n, i + 1, j, num + 1);
        dfs(ans, visit, n, i, j - 1, num + 1);
        dfs(ans, visit, n, i - 1, j, num + 1);
    }

    private boolean inbound(int n, int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}
