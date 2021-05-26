package com.leetcode;

import java.util.Arrays;

public class Solution_1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < k) {
                ans = Math.abs(ans - k) > Math.abs(nums[left] + nums[right] - k) ? nums[left] + nums[right] : ans;
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
