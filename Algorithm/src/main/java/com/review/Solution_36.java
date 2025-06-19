package com.review;

import java.util.HashSet;
import java.util.Set;

public class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!set.contains(board[i][j])) {
                    if (board[i][j] != '.') set.add(board[i][j]);
                } else {
                    return false;
                }
            }
            set.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!set.contains(board[j][i])) {
                    if (board[j][i] != '.') set.add(board[j][i]);
                } else {
                    return false;
                }
            }
            set.clear();
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (!set.contains(board[k][l])) {
                            if (board[k][l] != '.') set.add(board[k][l]);
                        } else {
                            return false;
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
