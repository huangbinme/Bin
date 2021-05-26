package com.solutions;

public class Solution_79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] booleans = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, booleans, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] booleans, String word, int wordIndex, int x, int y) {
        if (!validate(board, booleans, word, wordIndex, x, y)) return false;
        if (wordIndex == word.length() - 1) return true;
        booleans[x][y] = true;
        if (dfs(board, booleans, word, wordIndex + 1, x + 1, y)) return true;
        if (dfs(board, booleans, word, wordIndex + 1, x - 1, y)) return true;
        if (dfs(board, booleans, word, wordIndex + 1, x, y + 1)) return true;
        if (dfs(board, booleans, word, wordIndex + 1, x, y - 1)) return true;
        booleans[x][y] = false;
        return false;
    }

    private boolean validate(char[][] board, boolean[][] booleans, String word, int wordIndex, int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == word.charAt(wordIndex) && !booleans[x][y];
    }
}
