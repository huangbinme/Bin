package com.leetcode.offer;

public class Solution_57 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1, sum = nums[l] + nums[r];
        while (sum != target) {
            if (sum > target) {
                r--;
            } else {
                l++;
            }
            sum = nums[l] + nums[r];
        }
        return new int[]{nums[l], nums[r]};
    }
}
