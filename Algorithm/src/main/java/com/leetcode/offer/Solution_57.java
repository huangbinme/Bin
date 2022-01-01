package com.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution_57 {
    public int[][] findContinuousSequence(int target) {
        int max = target / 2 + 1;
        List<int[]> list = new ArrayList<>();
        int sum = 3, l = 1, r = 2;
        while (l < r && r <= max + 1) {
            if (sum >= target) {
                if (sum == target) {
                    int[] ints = new int[r - l + 1];
                    for (int i = 0; i < ints.length; i++) {
                        ints[i] = l + i;
                    }
                    list.add(ints);
                }
                sum -= l;
                l++;
            } else {
                r++;
                sum += r;
            }
        }
        return list.toArray(new int[][]{});
    }
}
