package com.leetcode;

public class Solution_704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = getMid(left, right);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= target && nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
