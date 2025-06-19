package com.review;

public class Solution_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] cp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cp[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = cp[i][j];
            }
        }
    }
}
