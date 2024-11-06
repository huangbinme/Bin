package com.leetcode;

import java.util.Arrays;

public class Solution_3254 {
    public int[] resultsArray(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        int c = 0;//以num[i]为末端，连续且上升的子数组的长度
        for (int i = 0; i < nums.length; i++) {
            c = (i == 0 || nums[i] - nums[i - 1] != 1) ? 1 : (c + 1);
            if (c >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }
}
