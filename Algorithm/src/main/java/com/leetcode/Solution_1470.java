package com.leetcode;

public class Solution_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length * 2];
        int ansP = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            ans[ansP] = nums[i];
            ansP += 2;
        }
        ansP = 1;
        for (int i = nums.length / 2; i < nums.length; i++) {
            ans[ansP] = nums[i];
            ansP += 2;
        }
        return ans;
    }
}
