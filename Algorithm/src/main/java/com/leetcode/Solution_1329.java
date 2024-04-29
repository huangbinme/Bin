package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_1329 {
    public int[][] diagonalSort(int[][] mat) {
        for (int i = 0; i < mat[0].length; i++) {
            sort(0, i, mat);
        }
        for (int i = 1; i < mat.length; i++) {
            sort(i, 0, mat);
        }
        return mat;
    }

    private void sort(int i, int j, int[][] mat) {
        List<Integer> list = new ArrayList<>();
        int startI = i, startJ = j;
        while (i < mat.length && j < mat[0].length) {
            list.add(mat[i++][j++]);
        }
        list.sort(Comparator.naturalOrder());
        int k = 0;
        while (startI < mat.length && startJ < mat[0].length) {
            mat[startI++][startJ++] = list.get(k++);
        }
    }
}
