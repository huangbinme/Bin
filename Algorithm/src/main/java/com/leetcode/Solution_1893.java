package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.<int[]>comparingInt(value -> value[0]).thenComparingInt(value -> value[1]));
        for (int[] ints : ranges) {
            if (ints[0] > left) return false;
            if (ints[1] >= left) {
                if (left >= ints[0] && right <= ints[1]) return true;
                left = ints[1] + 1;
            }
        }
        return false;
    }
}
