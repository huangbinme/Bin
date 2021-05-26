package com.leetcode;

public class Solution_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = -1;
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i + 1][0] > target) {
                s = i;
                break;
            }
        }
        s = s == -1 ? matrix.length - 1 : s;
        int left = 0;
        int right = matrix[s].length - 1;
        while (left + 1 < right) {
            int mid = getMid(left, right);
            if (matrix[s][mid] == target) {
                return true;
            } else if (matrix[s][mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return matrix[s][right] == target || matrix[s][left] == target;
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
