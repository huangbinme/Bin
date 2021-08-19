package com.leetcode.offer;

public class Solution_53 {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) return nums[0] == 0 ? 1 : 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] == l && nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
