package com.leetcode;

import java.util.Arrays;

public class Solution_5735 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i];
            if (sum > coins) return i;
        }
        return costs.length;
    }
}
