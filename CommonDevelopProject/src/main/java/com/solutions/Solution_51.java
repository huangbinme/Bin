package com.solutions;

import java.util.*;

public class Solution_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        if (n == 1) {
            result.add(Arrays.asList("Q"));
            return result;
        }
        boolean[] left = getBoard(2 * n - 1);
        boolean[] right = getBoard(2 * n - 1);
        boolean[] verticalBoard = getBoard(n);
        Deque<Integer> deque = new LinkedList<>();
        dfs(result, deque, n, 0, left, right, verticalBoard);
        return result;
    }

    private void dfs(List<List<String>> result, Deque<Integer> deque, int chessCount, int chessId, boolean[] left, boolean[] right, boolean[] verticalBoard) {
        if (chessId == chessCount) {
            result.add(convert(deque, chessCount));
            return;
        }
        for (int i = 0; i < chessCount; i++) {
            if (validateChess(left, right, verticalBoard, chessId, i, chessCount)) {
                deque.offerLast(i);
                chessOperation(left, right, verticalBoard, chessCount, chessId, i, true);
                dfs(result, deque, chessCount, chessId + 1, left, right, verticalBoard);
                deque.pollLast();
                chessOperation(left, right, verticalBoard, chessCount, chessId, i, false);
            }
        }
    }

    private List<String> convert(Deque<Integer> deque, int n) {
        List<String> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>(deque);
        integers.forEach(num -> list.add(getLine(num, n)));
        return list;
    }

    private boolean[] getBoard(int n) {
        return new boolean[n];
    }

    private void chessOperation(boolean[] left, boolean[] right, boolean[] verticalBoard, int n, int x, int y, boolean lay) {
        verticalBoard[y] = lay;
        left[x + y] = lay;
        right[Math.abs(x) + Math.abs(y - (n - 1))] = lay;
    }

    private boolean validateChess(boolean[] left, boolean[] right, boolean[] verticalBoard, int x, int y, int n) {
        return !verticalBoard[y] && !left[x + y] && !right[Math.abs(x) + Math.abs(y - (n - 1))];
    }

    private String getLine(int index, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) stringBuilder.append(".");
        return stringBuilder.replace(index, index + 1, "Q").toString();
    }
}
