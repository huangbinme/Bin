package com.leetcode.offer;

public class Solution_53 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == target ? 1 : 0;
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        int ans = 0;
        while (l >= 0) {
            if (nums[l--] == target) {
                ans++;
            } else {
                break;
            }
        }
        while (r < nums.length) {
            if (nums[r++] == target) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
