package com.leetcode;

public class Solution_1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int value = values[0], index = 0, ans = 0;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, values[i] + value + index - i);
            if (values[i] >= (value - (i - index))) {
                value = values[i];
                index = i;
            }
        }
        return ans;
    }
}
