package com.leetcode;

public class Solution_598 {
    public int maxCount(int m, int n, int[][] ops) {
        int maxAreaM = m, maxAreaN = n;
        for (int i = 0; i < ops.length; i++) {
            maxAreaM = Math.min(maxAreaM, ops[i][0]);
            maxAreaN = Math.min(maxAreaN, ops[i][1]);
        }
        return maxAreaM * maxAreaN;
    }
}
