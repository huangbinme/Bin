package com.review;

public class Solution_1004 {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zero = 0, ans = 0;
        while (r < nums.length) {
            while (nums[r] == 0 && zero + 1 > k) {
                if (nums[l++] == 0) zero--;
            }
            if (nums[r] == 0) zero++;
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
