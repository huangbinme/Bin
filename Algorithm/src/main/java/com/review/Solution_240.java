package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, matrix[0].length - 1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int i, int j) {
        if (!(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)) return false;
        if (matrix[i][j] == target) return true;
        return matrix[i][j] > target ? searchMatrix(matrix, target, i, j - 1) : searchMatrix(matrix, target, i + 1, j);
    }

    public static List<Integer> getRemovableIndices(String str1, String str2) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        int diff = -1, i = 0;
        while (i < str2.length()) {
            if (str2.charAt(i) != str1.charAt(i)) {
                diff = i;
                break;
            } else {
                i++;
            }
        }
        diff = diff == -1 ? str1.length() - 1 : diff;
        StringBuilder sb = new StringBuilder(str1);
        sb.deleteCharAt(diff);
        if (!sb.toString().equals(str2)) return Arrays.asList(-1);
        int k = diff;
        while (k - 1 >= 0 && str1.charAt(k - 1) == str1.charAt(diff)) k--;
        for (int j = k; j < str1.length() && str1.charAt(j) == str1.charAt(diff); j++) {
            ans.add(j);
        }
        return ans;
    }
}
