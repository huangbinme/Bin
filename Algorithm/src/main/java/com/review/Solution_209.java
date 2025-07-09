package com.review;

public class Solution_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (r < nums.length) {
            if (nums[r] >= target) return 1;
            while (sum + nums[r] >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
            sum += nums[r++];
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
