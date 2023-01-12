package com.leetcode.offer;

public class Solution_009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0, ans = 0, win = 1;
        while (r < nums.length) {
            win *= nums[r];
            while (win >= k && l < r) {
                win /= nums[l++];
            }
            if (win < k) ans += (r - l + 1);
            r++;
        }
        return ans;
    }
}