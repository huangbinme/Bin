package com.leetcode;

import java.util.Arrays;

public class Solution_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] ints = new int[k];
        return dfs(nums, target, ints, 0, 0);
    }

    private boolean dfs(int[] nums, int target, int[] sum, int start, int count) {
        if (count == nums.length) {
            return Arrays.stream(sum).allMatch(a -> a == sum[0]);
        }
        for (int i : sum) {
            if (i > target) return false;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < sum.length; j++) {
                if(sum[j] + num > target) continue;
                sum[j] += num;
                if(sum[j] > target) continue;
                boolean re = dfs(nums, target, sum, i + 1, count + 1);
                sum[j] -= num;
                if (re) return true;
            }
        }
        return false;
    }
}
