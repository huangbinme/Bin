package com.leetcode;

public class Solution_2639 {
    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                max = Math.max(max, getLength(grid[i][j]));
            }
            ans[j] = max;
        }
        return ans;
    }

    private int getLength(int i) {
        int ans = i < 0 ? 1 : 0;
        i = Math.abs(i);
        while (i >= 10) {
            i /= 10;
            ans++;
        }
        return ans + 1;
    }
}
