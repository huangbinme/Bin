package com.leetcode;

public class Solution_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int l = 0, r = 0, ans = 0, count = 0;
        while (r < nums.length) {
            count += nums[r] % 2;
            if (count == k) {
                int subL = l, subR = r + 1, lCount = 0, rCount = 0;
                while (nums[subL] % 2 == 0) {
                    subL++;
                    lCount++;
                }
                while (subR < nums.length && nums[subR] % 2 == 0) {
                    rCount++;
                    subR++;
                }
                ans += (lCount + 1) * (rCount + 1);
                count--;
                l = subL + 1;
            }
            r++;
        }
        return ans;
    }
}
