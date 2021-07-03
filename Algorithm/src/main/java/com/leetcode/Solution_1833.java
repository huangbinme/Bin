package com.leetcode;

import java.util.Arrays;

public class Solution_1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0, m = coins;
        for (int i = 0; i < costs.length; i++) {
            if (m - costs[i] >= 0) {
                ans++;
                m -= costs[i];
            } else {
                return ans;
            }
        }
        return ans;
    }
}
