package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] ints = new int[k];
        nums = Arrays.stream(nums).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        return dfs(nums, target, ints, 0, 0);
    }

    private boolean dfs(int[] nums, int target, int[] sum, int numIndex, int count) {
        if (count == nums.length) {
            return Arrays.stream(sum).allMatch(a -> a == sum[0]);
        }
        int num = nums[numIndex];
        for (int j = 0; j < sum.length; j++) {
            if (numIndex == 0 && j != 0) break;
            if (j > 0 && sum[j - 1] == sum[j]) continue;
            if (sum[j] + num > target) continue;
            sum[j] += num;
            boolean re = dfs(nums, target, sum, numIndex + 1, count + 1);
            sum[j] -= num;
            if (re) return true;
        }
        return false;
    }
}
