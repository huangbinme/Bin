package com.solutions;

public class Solution_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0, ans = 0;
        while (r < nums.length) {
            while (nums[r] == 0) {
                l = ++r;
                if (r == nums.length) return ans;
            }
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
