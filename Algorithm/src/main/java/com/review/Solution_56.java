package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (list.get(list.size() - 1)[1] >= interval[0]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            } else {
                list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
