package com.leetcode;

public class Solution_1049 {
    int ans = Integer.MAX_VALUE;

    public int lastStoneWeightII(int[] stones) {
        dfs(stones, 0, 0);
        return ans;
    }

    private void dfs(int[] stones, int index, int sum) {
        if (index == stones.length) {
            if(sum >= 0) ans = Math.min(ans, sum);
            return;
        }
        dfs(stones, index + 1, sum + stones[index]);
        dfs(stones, index + 1, sum - stones[index]);
    }
}
