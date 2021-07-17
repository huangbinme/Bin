package com.leetcode;

public class Solution_463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (top(grid, i, j)) ans++;
                    if (right(grid, i, j)) ans++;
                    if (bottom(grid, i, j)) ans++;
                    if (left(grid, i, j)) ans++;
                }
            }
        }
        return ans;
    }

    private boolean left(int[][] grid, int i, int j) {
        return j == 0 || grid[i][j - 1] == 0;
    }

    private boolean bottom(int[][] grid, int i, int j) {
        return i == grid.length - 1 || grid[i + 1][j] == 0;
    }

    private boolean right(int[][] grid, int i, int j) {
        return j == grid[0].length - 1 || grid[i][j + 1] == 0;
    }

    private boolean top(int[][] grid, int i, int j) {
        return i == 0 || grid[i - 1][j] == 0;
    }
}
