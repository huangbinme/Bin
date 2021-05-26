package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        boolean[][] record = new boolean[matrix.length][matrix[0].length];
        dfs(list, record, matrix, 0, 0);
        return list;
    }

    private void dfs(List<Integer> list, boolean[][] record, int[][] matrix, int x, int y) {
        if (!validate(record, matrix, x + 1, y) && !validate(record, matrix, x - 1, y) && !validate(record, matrix, x, y + 1) && !validate(record, matrix, x, y - 1)) {
            if (validate(record, matrix, x, y)) {
                record[x][y] = true;
                list.add(matrix[x][y]);
            }
            return;
        }
        list.add(matrix[x][y]);
        record[x][y] = true;
        if (validate(record, matrix, x, y + 1)) {
            if (!validate(record, matrix, x - 1, y)) {
                dfs(list, record, matrix, x, y + 1);
            }
        }
        if (validate(record, matrix, x + 1, y)) dfs(list, record, matrix, x + 1, y);
        if (validate(record, matrix, x, y - 1)) dfs(list, record, matrix, x, y - 1);
        if (validate(record, matrix, x - 1, y)) dfs(list, record, matrix, x - 1, y);
    }

    private boolean validate(boolean[][] record, int[][] matrix, int x, int y) {
        return inArea(matrix, x, y) && !record[x][y];
    }

    private boolean inArea(int[][] matrix, int x, int y) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }
}
