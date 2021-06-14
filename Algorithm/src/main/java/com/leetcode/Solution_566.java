package com.leetcode;

public class Solution_566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) return mat;
        int[] index = new int[2];
        int[][] ans = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                ans[index[0]][index[1]] = mat[i][j];
                setUp(index, r, c);
            }
        }
        return ans;
    }

    private void setUp(int[] index, int r, int c) {
        index[1]++;
        if (index[1] == c) {
            index[1] = 0;
            index[0]++;
        }
    }
}
