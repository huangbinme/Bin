package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < mat[0].length; i++) {
            List<Integer> sub = new ArrayList<>();
            ans.add(sub);
            insert(mat, sub, 0, i);
        }
        for (int i = 1; i < mat.length; i++) {
            List<Integer> sub = new ArrayList<>();
            ans.add(sub);
            insert(mat, sub, i, mat[0].length - 1);
        }
        int[] ints = new int[mat[0].length * mat.length];
        int index = 0;
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> sub = ans.get(i);
            if (i % 2 == 0) {
                for (int j = sub.size() - 1; j >= 0; j--) {
                    ints[index++] = sub.get(j);
                }
            } else {
                for (int j = 0; j < sub.size(); j++) {
                    ints[index++] = sub.get(j);
                }
            }
        }
        return ints;
    }

    private void insert(int[][] mat, List<Integer> sub, int i, int j) {
        while (j >= 0 && i < mat.length) {
            sub.add(mat[i][j]);
            i++;
            j--;
        }
    }
}
