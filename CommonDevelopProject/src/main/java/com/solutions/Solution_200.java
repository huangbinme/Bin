package com.solutions;

public class Solution_200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    traverse(grid, i, j);
                }
            }
        }
        return count;
    }

    private void traverse(char[][] reverseRecord, int i, int j) {
        if (!inArea(reverseRecord, i, j) || reverseRecord[i][j] != '1') return;
        reverseRecord[i][j] = '2';
        traverse(reverseRecord, i, j + 1);
        traverse(reverseRecord, i + 1, j);
        traverse(reverseRecord, i - 1, j);
        traverse(reverseRecord, i, j - 1);
    }

    private boolean inArea(char[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
