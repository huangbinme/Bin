package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        boolean newIntervalMerge = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (newIntervalMerge) {
                int[] last = ans.get(ans.size() - 1);
                if (last[1] >= interval[0]) {
                    last[1] = Math.max(last[1], interval[1]);
                } else {
                    ans.add(interval);
                }
            } else {
                if (!(newInterval[1] < interval[0] || interval[1] < newInterval[0])) {
                    newIntervalMerge = true;
                    interval[0] = Math.min(interval[0], newInterval[0]);
                    interval[1] = Math.max(interval[1], newInterval[1]);
                    ans.add(interval);
                } else if (newInterval[1] < interval[0]) {
                    ans.add(newInterval);
                    ans.add(interval);
                    newIntervalMerge = true;
                } else {
                    ans.add(interval);
                }
            }
        }
        if (!newIntervalMerge) {
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
