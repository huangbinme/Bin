package com.leetcode;

public class Solution_2923 {
    public int findChampion(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            boolean isChampion = true;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    isChampion = false;
                    break;
                }
            }
            if (isChampion) return i;
        }
        return -1;
    }
}
