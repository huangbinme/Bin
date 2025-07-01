package com.review;

public class Solution_79 {

    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, visit, 0, word, i, j);
            }
        }
        return ans;
    }

    private void dfs(char[][] board, boolean[][] visit, int matched, String word, int x, int y) {
        if (ans) return;
        if (matched == word.length()) {
            ans = true;
            return;
        }
        if (!(x >= 0 && x < board.length && y >= 0 && y < board[0].length)) return;
        if (visit[x][y] || word.charAt(matched) != board[x][y]) return;
        visit[x][y] = true;
        dfs(board, visit, matched + 1, word, x - 1, y);
        dfs(board, visit, matched + 1, word, x + 1, y);
        dfs(board, visit, matched + 1, word, x, y + 1);
        dfs(board, visit, matched + 1, word, x, y - 1);
        visit[x][y] = false;
    }
}
