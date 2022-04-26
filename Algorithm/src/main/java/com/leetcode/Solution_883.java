package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_883 {
    public int projectionArea(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, grid[i][j]);
                if (grid[i][j] != 0) ans++;
            }
            ans += max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}
