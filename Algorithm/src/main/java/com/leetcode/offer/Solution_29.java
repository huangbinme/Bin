package com.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        boolean[][] ifOutput = new boolean[matrix.length][matrix[0].length];
        int[] ans = new int[matrix.length * matrix[0].length];
        dfs(matrix, ifOutput, ans, 0, 0, 0);
        return ans;
    }

    private void dfs(int[][] matrix, boolean[][] ifOutput, int[] ans, int index, int x, int y) {
        if (!inbound(matrix, x, y) || ifOutput[x][y]) return;
        ifOutput[x][y] = true;
        ans[index++] = matrix[x][y];
        if (!inbound(matrix, x - 1, y) || ifOutput[x - 1][y]) dfs(matrix, ifOutput, ans, index, x, y + 1);
        dfs(matrix, ifOutput, ans, index, x + 1, y);
        dfs(matrix, ifOutput, ans, index, x, y - 1);
        dfs(matrix, ifOutput, ans, index, x - 1, y);
    }

    private boolean inbound(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}
