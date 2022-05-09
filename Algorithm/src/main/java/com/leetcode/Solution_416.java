package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> copy = new HashSet<>(set);
            for (Integer inSet : copy) {
                if (inSet + nums[i] < target) {
                    set.add(inSet + nums[i]);
                } else if (inSet + nums[i] == target || nums[i] == target || inSet == target) {
                    return true;
                }
            }
            if (nums[i] < target) set.add(nums[i]);
        }
        return false;
    }
}
