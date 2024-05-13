package com.leetcode;

import java.util.Arrays;

public class Solution_994 {

    public int orangesRotting(int[][] grid) {
        boolean hasStale = true;
        int ans = -1;
        while (hasStale) {
            hasStale = false;
            int[][] newGrid = copy(grid);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        if (check(i - 1, j, grid) && grid[i - 1][j] == 1) {
                            newGrid[i - 1][j] = 2;
                            hasStale = true;
                        }
                        if (check(i + 1, j, grid) && grid[i + 1][j] == 1) {
                            newGrid[i + 1][j] = 2;
                            hasStale = true;
                        }
                        if (check(i, j + 1, grid) && grid[i][j + 1] == 1) {
                            newGrid[i][j + 1] = 2;
                            hasStale = true;
                        }
                        if (check(i, j - 1, grid) && grid[i][j - 1] == 1) {
                            newGrid[i][j - 1] = 2;
                            hasStale = true;
                        }
                    }
                }
            }
            ans++;
            grid = newGrid;
        }
        return hasNonStale(grid) ? -1 : ans;
    }

    private boolean hasNonStale(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return true;
            }
        }
        return false;
    }

    private boolean check(int i, int j, int[][] grid) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }

    private int[][] copy(int[][] grid) {
        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        return copy;
    }
}