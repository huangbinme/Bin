package com.leetcode;

public class Solution_289 {

    public void gameOfLife(int[][] board) {
        int[][] copy = copyBoard(board);
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                int aliveRound = getAliveRound(i, j, copy);
                int ans = -1;
                if (aliveRound < 2) {
                    ans = 0;
                } else if (aliveRound == 3) {
                    ans = 1;
                } else if (aliveRound > 3) {
                    ans = 0;
                } else {
                    ans = board[i][j];
                }
                board[i][j] = ans;
            }
        }
    }

    private int getAliveRound(int i, int j, int[][] copy) {
        int ans = 0;
        ans += isAlive(i - 1, j - 1, copy) ? 1 : 0;
        ans += isAlive(i - 1, j, copy) ? 1 : 0;
        ans += isAlive(i - 1, j + 1, copy) ? 1 : 0;
        ans += isAlive(i, j - 1, copy) ? 1 : 0;
        ans += isAlive(i, j + 1, copy) ? 1 : 0;
        ans += isAlive(i + 1, j - 1, copy) ? 1 : 0;
        ans += isAlive(i + 1, j, copy) ? 1 : 0;
        ans += isAlive(i + 1, j + 1, copy) ? 1 : 0;
        return ans;
    }

    private boolean isAlive(int i, int j, int[][] copy) {
        if (!(i >= 0 && i < copy.length && j >= 0 && j < copy[0].length)) return false;
        return copy[i][j] == 1;
    }

    private int[][] copyBoard(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
}
