package com.leetcode;

public class Solution_1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        int[] point = null;
        for (int i = 0; i < points.length; i++) {
            int[] cur = points[i];
            if (x == cur[0] || y == cur[1]) {
                if (point == null) {
                    point = cur;
                    ans = i;
                } else {
                    int preDis = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                    int curDis = Math.abs(x - cur[0]) + Math.abs(y - cur[1]);
                    if (curDis < preDis) {
                        ans = i;
                        point = cur;
                    }
                }
            }
        }
        return ans;
    }
}
