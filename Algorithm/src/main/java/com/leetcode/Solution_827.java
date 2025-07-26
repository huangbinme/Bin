package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_827 {
    public int largestIsland(int[][] grid) {
        int ans = 0;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 1;
        int[][] islandIndex = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && islandIndex[i][j] == 0) {
                    int size = dfs(grid, islandIndex, islandId, 0, i, j);
                    islandSize.put(islandId++, size);
                    ans = Math.max(ans, size);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int afterConnect = 1;
                    int[] islandAdd = new int[islandId];
                    afterConnect += connect(i - 1, j, islandSize, islandIndex, islandAdd);
                    afterConnect += connect(i + 1, j, islandSize, islandIndex, islandAdd);
                    afterConnect += connect(i, j - 1, islandSize, islandIndex, islandAdd);
                    afterConnect += connect(i, j + 1, islandSize, islandIndex, islandAdd);
                    ans = Math.max(ans, afterConnect);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int[][] islandIndex, int islandId, int islandSize, int i, int j) {
        if (!(i >= 0 && i < islandIndex.length && j >= 0 && j < islandIndex[0].length)) return 0;
        if (grid[i][j] == 0 || (grid[i][j] == 1 && islandIndex[i][j] != 0)) return 0;
        islandIndex[i][j] = islandId;
        islandSize += dfs(grid, islandIndex, islandId, 0, i - 1, j);
        islandSize += dfs(grid, islandIndex, islandId, 0, i + 1, j);
        islandSize += dfs(grid, islandIndex, islandId, 0, i, j - 1);
        islandSize += dfs(grid, islandIndex, islandId, 0, i, j + 1);
        return islandSize + 1;
    }

    private int connect(int i, int j, Map<Integer, Integer> map, int[][] islandIndex, int[] islandAdd) {
        if (!(i >= 0 && i < islandIndex.length && j >= 0 && j < islandIndex[0].length)) return 0;
        if (islandIndex[i][j] == 0) return 0;
        if (islandAdd[islandIndex[i][j]] != 0) return 0;
        islandAdd[islandIndex[i][j]] = 1;
        return map.get(islandIndex[i][j]);
    }

}
