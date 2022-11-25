package com.leetcode;

public class Solution_795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0, p1 = -1, p2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                p2 = i;
            } else if (nums[i] < left) {
                ans += Math.max((p1 - p2), 0);
            } else {
                ans += (i - p2);
                p1 = i;
            }
        }
        return ans;
    }
}
