package com.leetcode;

public class Solution_2908 {
    public int minimumSum(int[] nums) {
        int l = nums[0], r = nums[nums.length - 1], ans = Integer.MAX_VALUE;
        int[] minR = new int[nums.length];
        for (int i = minR.length - 2; i > 0; i--) {
            r = Math.min(r, nums[i + 1]);
            minR[i] = r;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            l = Math.min(l, nums[i - 1]);
            if (nums[i] > minR[i] && nums[i] > l) {
                ans = Math.min(ans, nums[i] + minR[i] + l);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
