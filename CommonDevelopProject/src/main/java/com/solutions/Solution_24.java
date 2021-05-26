package com.solutions;

public class Solution_24 {

    boolean ans = false;

    public boolean searchMatrix(int[][] matrix, int target) {
        dfs(matrix, target, 0, matrix[0].length - 1);
        return ans;
    }

    private void dfs(int[][] matrix, int target, int x, int y) {
        if (y < 0 || x >= matrix.length) return;
        if (matrix[x][y] == target) {
            ans = true;
            return;
        }
        if (matrix[x][y] > target) {
            dfs(matrix, target, x, y - 1);
        } else if (matrix[x][y] < target) {
            dfs(matrix, target, x + 1, y);
        }
    }
}
