package com.solutions;

import java.util.LinkedHashSet;

public class Solution_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            if (set.size() == k) set.remove(nums[i - k]);
            set.add(nums[i]);
        }
        return false;
    }
}
