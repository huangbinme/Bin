package com.leetcode;

public class Solution_747 {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return -1;
        int max = -1, sec = -1, ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                sec = max;
                max = nums[i];
            }else if(nums[i] > sec){
                sec = nums[i];
            }
            if (nums[i] == max) ans = i;
        }
        return max >= sec * 2 ? ans : -1;
    }
}
