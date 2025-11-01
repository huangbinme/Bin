package com.leetcode;

public class Solution_329 {
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int[][] note = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int k = dfs(matrix, note, i, j);
                note[i][j] = k;
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int[][] note, int i, int j) {
        if (note[i][j] != 0) return note[i][j];
        note[i][j] = 1;
        if (inbound(i - 1, j, matrix) && matrix[i - 1][j] > matrix[i][j]) {
            note[i][j] = Math.max(note[i][j], 1 + dfs(matrix, note, i - 1, j));
        }
        if (inbound(i + 1, j, matrix) && matrix[i + 1][j] > matrix[i][j]) {
            note[i][j] = Math.max(note[i][j], 1 + dfs(matrix, note, i + 1, j));
        }
        if (inbound(i, j + 1, matrix) && matrix[i][j + 1] > matrix[i][j]) {
            note[i][j] = Math.max(note[i][j], 1 + dfs(matrix, note, i, j + 1));
        }
        if (inbound(i, j - 1, matrix) && matrix[i][j - 1] > matrix[i][j]) {
            note[i][j] = Math.max(note[i][j], 1 + dfs(matrix, note, i, j - 1));
        }
        return note[i][j];
    }

    private boolean inbound(int i, int j, int[][] matrix) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
