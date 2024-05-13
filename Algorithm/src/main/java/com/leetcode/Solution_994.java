package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_994 {

    public int orangesRotting(int[][] grid) {
        List<int[]> staleList = new ArrayList<>();
        int count = 0, ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) staleList.add(new int[]{i, j});
                if (grid[i][j] != 0) count++;
            }
        }
        int stat = 1;
        while (stat > 0) {
            stat = 0;
            List<int[]> newStaleList = new ArrayList<>(staleList);
            for (int[] ints : staleList) {
                int i = ints[0], j = ints[1];
                stat += affect(i - 1, j, grid, newStaleList);
                stat += affect(i, j - 1, grid, newStaleList);
                stat += affect(i + 1, j, grid, newStaleList);
                stat += affect(i, j + 1, grid, newStaleList);
            }
            if (stat > 0) ans++;
            staleList = newStaleList;
        }
        return staleList.size() == count ? ans : -1;
    }

    private int affect(int i, int j, int[][] grid, List<int[]> newStaleList) {
        if (check(i, j, grid) && grid[i][j] == 1) {
            grid[i][j] = 2;
            newStaleList.add(new int[]{i, j});
            return 1;
        } else {
            return 0;
        }
    }

    private boolean check(int i, int j, int[][] grid) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}