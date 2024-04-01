package com.leetcode;

public class Solution_33 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[mid] && nums[l] <= target && target <= nums[mid]) {
                r = mid;
            } else if (nums[mid] < nums[r] && (target <= nums[mid] || nums[r] < target)) {
                r = mid;
            } else if (l == mid && nums[l] == target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
