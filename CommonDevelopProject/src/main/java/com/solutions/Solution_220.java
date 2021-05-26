package com.solutions;

import java.util.TreeSet;

public class Solution_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || nums.length == 1 || k == 0) return false;
        if (k >= nums.length) k = nums.length - 1;
        TreeSet<Long> ts = new TreeSet<>();
        ts.add((long) nums[0]);
        int removeIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (checkTs(ts, nums[i], t)) return true;
            ts.add((long) nums[i]);
            if (ts.size() == k + 1) ts.remove((long) nums[removeIndex++]);
        }
        return false;
    }

    private boolean checkTs(TreeSet<Long> ts, int num, int t) {
        Long larger = ts.ceiling((long) num);
        Long smaller = ts.floor((long) num);
        if (larger != null && Math.abs(larger - (long) num) <= t) return true;
        return smaller != null && Math.abs(smaller - (long) num) <= t;
    }
}
