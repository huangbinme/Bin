package com.leetcode;

public class Solution_922 {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0, oddIndex = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans[evenIndex] = nums[i];
                evenIndex += 2;
            } else {
                ans[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }
        return ans;
    }
}
