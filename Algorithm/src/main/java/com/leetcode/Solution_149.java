package com.leetcode;

public class Solution_149 {
    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;
        int ans = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                int subAns = 2;
                for (int k = j + 1; k < points.length; k++) {
                    if (inOneLine(points[i], points[j], points[k])) {
                        subAns++;
                    }
                }
                ans = Math.max(ans, subAns);
            }
        }
        return ans;
    }

    public boolean inOneLine(int[] a1, int[] a2, int[] a3) {
        return (a2[1] - a1[1]) * (a3[0] - a2[0]) == (a3[1] - a2[1]) * (a2[0] - a1[0]);
    }
}
