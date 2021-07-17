package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_532 {
    public int findPairs(int[] nums, int k) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        set.add(nums[nums.length - 1]);
        int ans = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1] && k != 0) continue;
            if (set.contains(nums[i] + k) && (i == 0 || nums[i - 1] != nums[i])) ans++;
            set.add(nums[i]);
        }
        return ans;
    }
}
