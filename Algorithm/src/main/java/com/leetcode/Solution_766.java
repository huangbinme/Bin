package com.leetcode;

public class Solution_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length - 1; i++) {
            if (!validate(matrix, 0, i)) return false;
        }
        for (int i = 1; i < matrix.length - 1; i++) {
            if (!validate(matrix, i, 0)) return false;
        }
        return true;
    }

    private boolean validate(int[][] matrix, int x, int y) {
        int startX = x;
        int startY = y;
        int base = matrix[x][y];
        while (validateBound(matrix, startX, startY)) {
            if (matrix[startX++][startY++] != base) return false;
        }
        return true;
    }

    private boolean validateBound(int[][] matrix, int i, int j) {
        return i < matrix.length && j < matrix[0].length;
    }
}
