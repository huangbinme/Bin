package com.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < mat.length; i++) {
            add(i, 0, list, mat);
        }
        for (int i = 1; i < mat[0].length; i++) {
            add(mat.length - 1, i, list, mat);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) Collections.reverse(list.get(i));
        }
        int[] ans = new int[mat.length * mat[0].length];
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                ans[k++] = list.get(i).get(j);
            }
        }
        return ans;
    }

    private void add(int i, int j, List<List<Integer>> list, int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        while (i >= 0 && j < mat[0].length) {
            ans.add(mat[i--][j++]);
        }
        list.add(ans);
    }
}
