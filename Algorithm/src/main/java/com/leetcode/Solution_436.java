package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_436 {
    public int[] findRightInterval(int[][] intervals) {
        int[][] copy = new int[intervals.length][4];
        for (int i = 0; i < intervals.length; i++) {
            copy[i][0] = intervals[i][0];
            copy[i][1] = intervals[i][1];
            copy[i][2] = i;
        }
        Arrays.sort(copy, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < copy.length; i++) {
            copy[i][3] = find(copy, copy[i][1]);
        }
        int[] ans = new int[intervals.length];
        for (int i = 0; i < ans.length; i++) {
            ans[copy[i][2]] = copy[i][3];
        }
        return ans;
    }

    private int find(int[][] ints, int target) {
        int l = 0, r = ints.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (ints[mid][0] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return ints[l][0] >= target ? ints[l][2] : -1;
    }
}
