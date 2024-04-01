package com.leetcode;

public class Solution_200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] note = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!note[i][j] && grid[i][j] == '1') {
                    ans++;
                    update(i, j, note, grid);
                }
            }
        }
        return ans;
    }
    private void update(int i, int j, boolean[][] note, char[][] grid) {
        if (!(i >= 0 && i < note.length && j >= 0 && j < note[0].length)) return;
        if (grid[i][j] == '0' || note[i][j]) return;
        note[i][j] = true;
        update(i - 1, j, note, grid);
        update(i, j - 1, note, grid);
        update(i + 1, j, note, grid);
        update(i, j + 1, note, grid);
    }
}
