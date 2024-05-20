package com.leetcode;

public class Solution_1953 {
    public long numberOfWeeks(int[] milestones) {
        long max = Long.MIN_VALUE, sum = 0;
        for (int i = 0; i < milestones.length; i++) {
            max = Math.max(max, milestones[i]);
            sum += milestones[i];
        }
        sum -= max;
        return max > sum + 1 ? 2 * sum + 1 : sum + max;
    }
}
