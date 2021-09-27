package com.leetcode.offer;

public class Solution_12 {

    public boolean exist(char[][] board, String word) {
        boolean[][] ifSelect = new boolean[board.length][board[0].length];
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ans = dfs(board, word, ifSelect, 0, i, j, ans);
            }
        }
        return ans;
    }

    private boolean dfs(char[][] board, String word, boolean[][] ifSelect, int matchIndex, int i, int j, boolean ans) {
        if (matchIndex == word.length() || ans) return true;
        if (!inbound(board, i, j) || ifSelect[i][j] || word.charAt(matchIndex) != board[i][j]) return false;
        ifSelect[i][j] = true;
        ans = dfs(board, word, ifSelect, matchIndex + 1, i - 1, j, ans) ||
                dfs(board, word, ifSelect, matchIndex + 1, i + 1, j, ans) ||
                dfs(board, word, ifSelect, matchIndex + 1, i, j - 1, ans) ||
                dfs(board, word, ifSelect, matchIndex + 1, i, j + 1, ans);
        ifSelect[i][j] = false;
        return ans;
    }

    private boolean inbound(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
