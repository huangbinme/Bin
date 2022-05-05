package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] <= intervals[i][0]) {
                    dp[j] = intervals[i][1];
                    break;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) return i;
        }
        return intervals.length;
    }
}
