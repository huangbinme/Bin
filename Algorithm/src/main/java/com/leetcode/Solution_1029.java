package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_1029 {
    public int twoCitySchedCost(int[][] costs) {
        int ans = 0;
        Arrays.sort(costs, Comparator.comparingInt(a -> -1 * (a[0] - a[1])));
        for (int i = 0; i < costs.length; i++) {
            ans += i < costs.length / 2 ? costs[i][1] : costs[i][0];
        }
        return ans;
    }
}
