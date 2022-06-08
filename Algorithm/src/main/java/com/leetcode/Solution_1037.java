package com.leetcode;

public class Solution_1037 {
    public boolean isBoomerang(int[][] points) {
        return !inOneLine(points[0], points[1], points[3]);
    }

    public boolean inOneLine(int[] a1, int[] a2, int[] a3) {
        return (a1[0] == a2[0] && a2[0] == a3[0]) || ((a2[1] - a1[1]) * (a3[0] - a2[0]) == (a3[1] - a2[1]) * (a2[0] - a1[0]));
    }
}
