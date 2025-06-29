package com.review;

import java.util.Arrays;

public class Solution_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][matrix[0].length - 1]) {
                x = i;
            }
        }
        if (x == -1) return false;
        int[] search = matrix[x];
        int ans = Arrays.binarySearch(search, target);
        return ans >= 0 && ans < search.length;
    }
}