package com.leetcode;

public class Solution_3239 {
    public int minFlips(int[][] grid) {
        int column = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int j = 0, k = grid.length - 1;
            while (j < k) {
                if (grid[j][i] != grid[k][i]) column++;
                j++;
                k--;
            }
        }
        int row = 0;
        for (int i = 0; i < grid.length; i++) {
            int j = 0, k = grid[0].length - 1;
            while (j < k) {
                if (grid[i][j] != grid[i][k]) row++;
                j++;
                k--;
            }
        }
        return Math.min(column, row);
    }
}
