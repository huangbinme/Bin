package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1631 {
    public int minimumEffortPath(int[][] heights) {
        int[][] around = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(c -> c[2]));
        queue.offer(new int[]{0, 0, 0});
        boolean[][] note = new boolean[heights.length][];
        for (int i = 0; i < note.length; i++) {
            note[i] = new boolean[heights[0].length];
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], curCost = poll[2];
            if (x == heights.length - 1 && y == heights[0].length - 1) return curCost;
            if (note[x][y]) continue;
            note[x][y] = true;
            for (int i = 0; i < around.length; i++) {
                int newX = x + around[i][0], newY = y + around[i][1];
                if (inbound(heights, newX, newY)) {
                    int newCost = Math.max(curCost, Math.abs(heights[x][y] - heights[newX][newY]));
                    queue.offer(new int[]{newX, newY, newCost});
                }
            }
        }
        return 0;
    }

    private boolean inbound(int[][] heights, int x, int y) {
        return x >= 0 && x < heights.length && y >= 0 && y < heights[0].length;
    }
}
