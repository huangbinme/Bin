package com.leetcode;

public class Solution_1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int[][] preSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] + matrix[i][j] - preSum[i][j];
            }
        }
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[0].length; j++) {
                for (int k = 1; k <= i; k++) {
                    for (int l = 1; l <= j; l++) {
                        if (cal(preSum, i, j, k, l) == target) ans++;
                    }
                }
            }
        }
        return ans;
    }

    private int cal(int[][] preSum, int i, int j, int k, int l) {
        return preSum[i][j] - preSum[k - 1][j] - preSum[i][l - 1] + preSum[k - 1][l - 1];
    }
}
