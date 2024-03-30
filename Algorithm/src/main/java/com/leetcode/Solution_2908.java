package com.leetcode;

public class Solution_2908 {
    public int minimumSum(int[] nums) {
        int l = nums[0], r = nums[nums.length - 1], ans = Integer.MAX_VALUE;
        int[] minL = new int[nums.length], minR = new int[nums.length];
        for (int i = 1; i < minL.length - 1; i++) {
            l = Math.min(l, nums[i - 1]);
            minL[i] = l;
        }
        for (int i = minR.length - 2; i > 0; i--) {
            r = Math.min(r, nums[i + 1]);
            minR[i] = r;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > minR[i] && nums[i] > minL[i]) {
                ans = Math.min(ans, nums[i] + minR[i] + minL[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
