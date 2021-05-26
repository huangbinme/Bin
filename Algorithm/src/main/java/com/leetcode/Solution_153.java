package com.leetcode;

public class Solution_153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int mid = mid(left, right);
        do {
            if (nums[mid] >= nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
            mid = mid(left, right);
        } while (right - left != 1);
        return nums[right] < nums[left] ? nums[right] : nums[0];
    }

    private int mid(int left, int right) {
        return left + (right - left) / 2;
    }
}
