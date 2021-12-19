package com.leetcode;

public class Solution_419 {

    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    boolean case1 = isBlank(board, i, j - 1) && isBlank(board, i, j + 1) && isBlank(board, i - 1, j);
                    boolean case2 = isBlank(board, i, j - 1) && isBlank(board, i - 1, j) && isBlank(board, i + 1, j);
                    ans += case1 || case2 ? 1 : 0;
                }
            }
        }
        return ans;
    }

    private boolean isBlank(char[][] board, int i, int k) {
        return outbound(board, i, k) || board[i][k] == '.';
    }

    private boolean outbound(char[][] board, int i, int k) {
        return !(i >= 0 && i < board.length && k >= 0 && k < board[0].length);
    }
}
