package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        boolean[][] note = new boolean[matrix.length][matrix[0].length];
        dfs(ans, matrix, note, 0, 0);
        return ans;
    }

    private void dfs(List<Integer> ans, int[][] matrix, boolean[][] note, int i, int j) {
        if (!(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) || note[i][j]) return;
        ans.add(matrix[i][j]);
        note[i][j] = true;
        if (i - 1 >= 0 && !note[i - 1][j] && j + 1 < matrix[0].length && !note[i][j + 1]) dfs(ans, matrix, note, i - 1, j);
        dfs(ans, matrix, note, i, j + 1);
        dfs(ans, matrix, note, i + 1, j);
        dfs(ans, matrix, note, i, j - 1);
        dfs(ans, matrix, note, i - 1, j);
    }
}