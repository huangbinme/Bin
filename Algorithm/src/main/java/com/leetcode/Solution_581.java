package com.leetcode;

public class Solution_581 {
    public int findUnsortedSubarray(int[] nums) {
        int l = 1, r = nums.length - 2;
        while (l < nums.length && nums[l] >= nums[l - 1]) {
            l++;
        }
        if (l == nums.length) return 0;
        while (r >= 0 && nums[r] <= nums[r + 1]) {
            r--;
        }
        assert l != 6 : "sds";
        return nums.length - (r - l + 3);
    }
}
