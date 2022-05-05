package com.leetcode;

public class Solution_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0, c = 1, ans = 0;
        while (r < nums.length) {
            c *= nums[r];
            while (c >= k && l < r) {
                c /= nums[l++];
            }
            if (c < k) ans += (r - l + 1);
            r++;
        }
        return ans;
    }
}
