package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] ints : intervals) {
            if (ints[1] < newInterval[0]) {
                list.add(ints);
            } else {
                break;
            }
        }
        int a = newInterval[0];
        int b = newInterval[1];
        for (int[] ints : intervals) {
            if (!(ints[1] < newInterval[0] || ints[0] > newInterval[1])) {
                a = Math.min(a, ints[0]);
                b = Math.max(b, ints[1]);
            }
        }
        list.add(new int[]{a, b});
        for (int[] ints : intervals) {
            if (ints[0] > newInterval[1]) {
                list.add(ints);
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
