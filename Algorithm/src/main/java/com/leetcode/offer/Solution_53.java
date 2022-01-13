package com.leetcode.offer;

public class Solution_53 {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) return nums[0] == 0 ? 1 : 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] == l && nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] != target) return 0;
        int ans = 1;
        l--;
        r++;
        while (l >= 0 && nums[l--] == target) ans++;
        while (r < nums.length && nums[r++] == target) ans++;
        return ans;
    }
}
