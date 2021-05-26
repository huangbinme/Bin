package com.solutions;

public class Solution_1004 {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, ans = 0, zeroCount = 0;
        while (r < nums.length) {
            if (nums[r] == 0 && zeroCount == k) {
                while (nums[l++] == 1) ;
                zeroCount--;
            }
            if (nums[r] == 0) zeroCount++;
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
