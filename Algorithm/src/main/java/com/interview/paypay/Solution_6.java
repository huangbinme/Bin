package com.interview.paypay;

import java.util.ArrayList;
import java.util.List;

public class Solution_6 {
    public int[][] solution(int h, int w, String[] queries) {
        List<int[]> ans = new ArrayList<>();
        int[][] board = new int[h][w];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i].split(" ");
            String operation = query[0];
            int x = Integer.parseInt(query[1]), y = Integer.parseInt(query[2]);
            if (operation.equals("x")) {
                board[x][y] = 1;
            } else if (operation.equals(">")) {
                y++;
                while (isInBounds(board, x, y) && board[x][y] == 1) y++;
                addAns(ans, board, x, y);
            } else if (operation.equals("<")) {
                y--;
                while (isInBounds(board, x, y) && board[x][y] == 1) y--;
                addAns(ans, board, x, y);
            } else if (operation.equals("v")) {
                x++;
                while (isInBounds(board, x, y) && board[x][y] == 1) x++;
                addAns(ans, board, x, y);
            } else if (operation.equals("^")) {
                x--;
                while (isInBounds(board, x, y) && board[x][y] == 1) x--;
                addAns(ans, board, x, y);
            }
        }
        return ans.toArray(new int[0][]);
    }

    private void addAns(List<int[]> ans, int[][] board, int x, int y) {
        if (isInBounds(board, x, y)) {
            ans.add(new int[]{x, y});
        } else {
            ans.add(new int[]{-1, -1});
        }
    }

    private boolean isInBounds(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
