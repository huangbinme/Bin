package com.review;

public class Solution_200 {
    public int numIslands(char[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    updateVisit(i, j, grid, visit);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void updateVisit(int i, int j, char[][] grid, boolean[][] visit) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) return;
        if (grid[i][j] != '1' || visit[i][j]) return;
        visit[i][j] = true;
        updateVisit(i + 1, j, grid, visit);
        updateVisit(i - 1, j, grid, visit);
        updateVisit(i, j + 1, grid, visit);
        updateVisit(i, j - 1, grid, visit);
    }
}
