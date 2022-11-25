package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            list.add(get(mat, i, 0));
        }
        for (int i = 1; i < mat[0].length; i++) {
            list.add(get(mat, mat.length - 1, i));
        }
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(list.get(i));
            }
        }
        int[] ans = new int[mat.length * mat[0].length];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                ans[index++] = list.get(i).get(j);
            }
        }
        return ans;
    }

    private List<Integer> get(int[][] mat, int x, int y) {
        List<Integer> list = new ArrayList<>();
        while (inbound(mat, x, y)) {
            list.add(mat[x--][y++]);
        }
        return list;
    }

    private boolean inbound(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
