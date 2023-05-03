package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int[][] ints = new int[heights.length][2];
        for (int i = 0; i < heights.length; i++) {
            ints[i] = new int[]{heights[i], i};
        }
        Arrays.sort(ints, Comparator.comparingInt(v -> v[0] * -1));
        String[] ans = new String[names.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = names[ints[i][1]];
        }
        return ans;
    }
}
