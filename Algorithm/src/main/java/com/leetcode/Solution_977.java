package com.leetcode;

public class Solution_977 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int l = 0, r = nums.length - 1, ansIndex = nums.length - 1;
        while (l <= r) {
            ans[ansIndex--] = Math.abs(nums[l]) >= Math.abs(nums[r]) ? nums[l] * nums[l++] : nums[r] * nums[r--];
        }
        return ans;
    }
}
