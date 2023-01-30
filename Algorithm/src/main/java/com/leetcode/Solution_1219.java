package com.leetcode;

public class Solution_1219 {
    int ans = 0;

    public int getMaximumGold(int[][] grid) {
        boolean[][] note = new boolean[grid.length][grid[0].length];
        dfs(grid, note);
        return ans;
    }

    private void dfs(int[][] grid, boolean[][] note) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                note[i][j] = true;
                dfs(grid, note, i, j, grid[i][j]);
                note[i][j] = false;
            }
        }
    }

    private void dfs(int[][] grid, boolean[][] note, int i, int j, int count) {
        ans = Math.max(ans, count);
        note[i][j] = true;
        if (validate(grid, note, i - 1, j)) {
            dfs(grid, note, i - 1, j, count + grid[i - 1][j]);
        }
        if (validate(grid, note, i, j - 1)) {
            dfs(grid, note, i, j - 1, count + grid[i][j - 1]);
        }
        if (validate(grid, note, i + 1, j)) {
            dfs(grid, note, i + 1, j, count + grid[i + 1][j]);
        }
        if (validate(grid, note, i, j + 1)) {
            dfs(grid, note, i, j + 1, count + grid[i][j + 1]);
        }
        note[i][j] = false;
    }

    private boolean validate(int[][] grid, boolean[][] note, int i, int j) {
        return i >= 0 && i < note.length && j >= 0 && j < note[0].length && !note[i][j] && grid[i][j] != 0;
    }
}
