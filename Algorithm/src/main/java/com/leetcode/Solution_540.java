package com.leetcode;

public class Solution_540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length;
        while (r - l > 1) {
            int m = (r - l) / 2 + l;
            if (nums[m - 1] != nums[m] && nums[m] != nums[m + 1]) return nums[m];
            int s = nums[m] == nums[m - 1] ? m - 1 : m;
            if (s % 2 == 0) {
                l = s + 2;
            } else {
                r = s;
            }
        }
        return nums[l];
    }
}
