package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            if (set.size() == k + 1) set.remove(nums[j - k - 1]);
            if (set.contains(nums[j])) {
                return true;
            } else {
                set.add(nums[j]);
            }
        }
        return false;
    }
}
