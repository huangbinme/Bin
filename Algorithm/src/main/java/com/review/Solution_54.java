package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        dfs(ans, visit, matrix, 0, 0);
        return ans;
    }

    private void dfs(List<Integer> ans, boolean[][] visit, int[][] matrix, int i, int j) {
        if (!(validate(matrix, i, j))) return;
        if (visit[i][j]) return;
        ans.add(matrix[i][j]);
        visit[i][j] = true;
        if (!access(matrix, visit, i - 1, j) && !access(matrix, visit, i, j - 1))
            dfs(ans, visit, matrix, i, j + 1);
        dfs(ans, visit, matrix, i + 1, j);
        dfs(ans, visit, matrix, i, j - 1);
        dfs(ans, visit, matrix, i - 1, j);
    }

    private boolean access(int[][] matrix, boolean[][] visit, int i, int j) {
        return validate(matrix, i, j) && !visit[i][j];
    }

    private boolean validate(int[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
