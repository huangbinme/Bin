package com.solutions;

public class Solution_487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0, ans = 0, zero_index = -1;
        while (r < nums.length) {
            if (nums[r] == 0 && zero_index != -1) {
                l = zero_index + 1;
            }
            if (nums[r] == 0) zero_index = r;
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
