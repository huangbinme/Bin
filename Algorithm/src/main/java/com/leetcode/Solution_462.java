package com.leetcode;

import java.util.Arrays;

public class Solution_462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, ans = 0;
        while (l < r) {
            ans += nums[r] - nums[l];
            r--;
            l++;
        }
        return ans;
    }
}
