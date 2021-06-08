package com.leetcode;

public class Solution_494 {
    int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            ans += target == sum ? 1 : 0;
            return;
        }
        dfs(nums, target, sum + nums[index], index + 1);
        dfs(nums, target, sum - nums[index], index + 1);
    }
}
