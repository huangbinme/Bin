package com.leetcode;

public class Solution_695 {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] booleans = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !booleans[i][j]) {
                    int sub = calArea(grid, booleans, i, j, 0);
                    ans = Math.max(ans, sub);
                }
            }
        }
        return ans;
    }

    private int calArea(int[][] grid, boolean[][] booleans, int i, int j, int area) {
        if (!inBound(grid, i, j) || grid[i][j] == 0 || booleans[i][j]) return area;
        booleans[i][j] = true;
        int top = calArea(grid, booleans, i - 1, j, 0);
        int right = calArea(grid, booleans, i, j + 1, 0);
        int bottom = calArea(grid, booleans, i + 1, j, 0);
        int left = calArea(grid, booleans, i, j - 1, 0);
        return top + right + bottom + left + 1;
    }

    private boolean inBound(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
