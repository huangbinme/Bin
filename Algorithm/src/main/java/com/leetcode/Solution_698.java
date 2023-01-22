package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution_698 {
    boolean ans = false;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean[] isSet = new boolean[nums.length];
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sum.add(0);
        }
        dfs(nums, isSet, 0, sum);
        return ans;
    }

    private void dfs(int[] nums, boolean[] isSet, int count, List<Integer> sum) {
        if (count == nums.length) {
            ans = sum.stream().allMatch(a -> Objects.equals(a, sum.get(0)));
            return;
        }
        for (int i = 0; i < sum.size(); i++) {
            int curSum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (isSet[j]) continue;
                isSet[j] = true;
                curSum += nums[j];
                sum.set(i, sum.get(i) + curSum);

            }
        }
    }
}
