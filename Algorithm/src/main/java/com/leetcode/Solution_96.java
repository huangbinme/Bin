package com.leetcode;

public class Solution_96 {
    public int numTrees(int n) {
        int[][] note = new int[n + 2][n + 2];
        return dfs(1, n, note);
    }

    private int dfs(int l, int r, int[][] note) {
        if (l >= r) return 1;
        if (l + 1 == r) return 2;
        int ans = 0;
        for (int i = l; i <= r; i++) {
            int x = note[l][i - 1] != 0 ? note[l][i - 1] : dfs(l, i - 1, note);
            note[l][i - 1] = x;
            int y = note[i + 1][r] != 0 ? note[i + 1][r] : dfs(i + 1, r, note);
            note[i + 1][r] = y;
            ans += (x * y);
        }
        return ans;
    }
}
