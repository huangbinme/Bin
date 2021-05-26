package com.solutions;

//- 这道题的回溯有几个特殊之处
//- 1.题目已经提供的数字，这是固定部分，不能回退。
//- 2.只有返回false时候才进行回退，因为我们的目的不是遍历所有的情况，只要有满足条件的一个结果就行。
//- 3.初始化数组时，把题目提供的数字放入我们的状态表中，并且不能修改。

public class Solution_37 {

    public void solveSudoku(char[][] board) {
        boolean[][] verticalSets = new boolean[9][9];
        boolean[][] horizontalSets = new boolean[9][9];
        boolean[][] subChessSets = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    chessOperation(verticalSets, horizontalSets, subChessSets, board, i, j, board[i][j], true);
                }
            }
        }
        dfs(verticalSets, horizontalSets, subChessSets, board, 0, 0);
    }

    private boolean dfs(boolean[][] verticalSets, boolean[][] horizontalSets, boolean[][] subChessSets, char[][] board, int x, int y) {
        if (x == 9) {
            x = 0;
            y = y + 1;
            if (y == 9) {
                return true;
            }
        }
        if (board[x][y] != '.') {
            return dfs(verticalSets, horizontalSets, subChessSets, board, x + 1, y);
        }
        for (int k = 1; k <= 9; k++) {
            if (validate(verticalSets, horizontalSets, subChessSets, x, y, Character.forDigit(k, 10))) {
                char digit = Character.forDigit(k, 10);
                chessOperation(verticalSets, horizontalSets, subChessSets, board, x, y, digit, true);
                if (dfs(verticalSets, horizontalSets, subChessSets, board, x + 1, y)) return true;
                chessOperation(verticalSets, horizontalSets, subChessSets, board, x, y, digit, false);
            }
        }
        return false;
    }

    private void chessOperation(boolean[][] verticalSets, boolean[][] horizontalSets, boolean[][] subChessSets, char[][] board, int x, int y, char chess, boolean put) {
        int subChessBoardIndex = (x / 3) * 3 + y / 3;
        int index = Character.digit(chess, 10) - 1;
        subChessSets[subChessBoardIndex][index] = put;
        verticalSets[y][index] = put;
        horizontalSets[x][index] = put;
        board[x][y] = put ? chess : '.';
    }

    private boolean validate(boolean[][] verticalSets, boolean[][] horizontalSets, boolean[][] subChessSets, int x, int y, char chess) {
        int subChessBoardIndex = (x / 3) * 3 + y / 3;
        int index = Character.digit(chess, 10) - 1;
        return !subChessSets[subChessBoardIndex][index] && !verticalSets[y][index] && !horizontalSets[x][index];
    }
}
