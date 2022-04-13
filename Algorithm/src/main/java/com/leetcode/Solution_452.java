package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int base = points[0][1], ans = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > base) {
                ans++;
                base = points[i][1];
            } else {
                base = Math.min(base, points[i][1]);
            }
        }
        return ans;
    }
}
