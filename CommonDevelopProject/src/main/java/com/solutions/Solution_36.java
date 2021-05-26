package com.solutions;

import java.util.HashSet;
import java.util.Set;

public class Solution_36 {
    Set<Character> set = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) if (!validateVertical(board, i)) return false;
        for (int i = 0; i < 9; i++) if (!validateHorizontal(board, i)) return false;
        for (int i = 0; i < 9; i++) if (!validateSubBoard(board, i)) return false;
        return true;
    }

    private boolean validateVertical(char[][] board, int index) {
        for (int i = 0; i < 9; i++) {
            if (isNotBlank(board[i][index])) {
                if (set.contains(board[i][index])) return false;
                set.add(board[i][index]);
            }
        }
        set.clear();
        return true;
    }

    private boolean validateHorizontal(char[][] board, int index) {
        for (int i = 0; i < 9; i++) {
            if (isNotBlank(board[index][i])) {
                if (set.contains(board[index][i])) return false;
                set.add(board[index][i]);
            }
        }
        set.clear();
        return true;
    }

    private boolean validateSubBoard(char[][] board, int index) {
        int minX = (index / 3) * 3;
        int maxX = minX + 2;
        int minY = (index % 3) * 3;
        int maxY = minY + 2;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (isNotBlank(board[i][j])) {
                    if (set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
        }
        set.clear();
        return true;
    }

    private boolean isNotBlank(char c) {
        return '.' != c;
    }
}
