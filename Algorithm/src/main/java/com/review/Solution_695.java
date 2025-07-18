package com.review;

public class Solution_695 {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    int area = getArea(i, j, grid, visit);
                    ans = Math.max(area, ans);
                }
            }
        }
        return ans;
    }

    private int getArea(int i, int j, int[][] grid, boolean[][] visit) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) return 0;
        if (grid[i][j] == 0 || visit[i][j]) return 0;
        visit[i][j] = true;
        int ans = 1;
        ans += getArea(i - 1, j, grid, visit);
        ans += getArea(i, j - 1, grid, visit);
        ans += getArea(i + 1, j, grid, visit);
        ans += getArea(i, j + 1, grid, visit);
        return ans;
    }
}
