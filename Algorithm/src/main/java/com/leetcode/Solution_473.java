package com.leetcode;

import java.util.Arrays;

public class Solution_473 {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        int[] sums = new int[4];
        Arrays.sort(matchsticks);
        return dfs(matchsticks, target, matchsticks.length - 1, sums);
    }

    private boolean dfs(int[] matchsticks, int target, int index, int[] sums) {
        if (index == -1) {
            return sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (matchsticks[index] + sums[i] > target) continue;
            sums[i] += matchsticks[index];
            if (dfs(matchsticks, target, index - 1, sums)) return true;
            sums[i] -= matchsticks[index];
        }
        return false;
    }
}
