package com.review;

public class Solution_153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (r - l == 1) return Math.min(nums[l], nums[r]);
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[mid] && nums[mid] < nums[r]) return nums[l];
            if (nums[l] < nums[mid]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            }
        }
        return nums[l];
    }
}
