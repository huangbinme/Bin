package com.review;

public class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] != target) return new int[]{-1, -1};
        while (l >= 0 && nums[l] == target) l--;
        while (r < nums.length && nums[r] == target) r++;
        return new int[]{l + 1, r - 1};
    }
}
