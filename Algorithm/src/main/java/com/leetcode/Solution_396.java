package com.leetcode;

public class Solution_396 {
    public int maxRotateFunction(int[] nums) {
        int subAns = 0, ans = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            subAns += i * nums[i];
            sum += nums[i];
        }
        ans = subAns;
        for (int i = nums.length - 1; i > 0; i--) {
            int change = sum - nums.length * nums[i];
            subAns += change;
            ans = Math.max(ans, subAns);
        }
        return ans;
    }
}
