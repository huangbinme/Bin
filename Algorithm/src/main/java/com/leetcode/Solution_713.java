package com.leetcode;

public class Solution_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int l = 0, r = 0, ans = 0, sum = 1;
        while (r < nums.length) {
            sum *= nums[r];
            while (sum >= k && r < nums.length) {
                sum /= nums[l++];
                if (l > r) r = l;
            }
            if (r >= nums.length) break;
            ans += (r - l + 1);
            r++;
        }
        return ans;
    }
}
