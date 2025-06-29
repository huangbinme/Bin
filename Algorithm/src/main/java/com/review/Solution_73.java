package com.review;

public class Solution_73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] mZero = new boolean[m], nZero = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    mZero[i] = true;
                    nZero[j] = true;
                }
            }
        }
        for (int i = 0; i < mZero.length; i++) {
            if (mZero[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < nZero.length; i++) {
            if (nZero[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
