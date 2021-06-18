package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        int[] base = intervals[0];
        int ans = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (base[1] <= intervals[i][0]) {
                base = intervals[i];
            } else {
                if (base[1] > intervals[i][1]) base = intervals[i];
                ans++;
            }
        }
        return ans;
    }
}
