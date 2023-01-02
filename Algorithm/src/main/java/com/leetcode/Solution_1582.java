package com.leetcode;

public class Solution_1582 {
    public int numSpecial(int[][] mat) {
        int[] xCount = new int[mat[0].length], yCount = new int[mat.length];
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    xCount[j]++;
                    yCount[i]++;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (xCount[j] == 1 && yCount[i] == 1) ans++;
                }
            }
        }
        return ans;
    }
}
