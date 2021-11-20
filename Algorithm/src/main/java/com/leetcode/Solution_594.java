package com.leetcode;

import java.util.Arrays;

public class Solution_594 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int r = 0, l = 0, ans = 0;
        while (l < nums.length) {
            while (!(nums[l] - nums[r] == 0 || nums[l] - nums[r] == 1)) {
                r++;
            }
            l++;
            if (l < nums.length && nums[l] - nums[r] == 1) ans = Math.max(ans, l - r + 1);
        }
        return ans;
    }
}
