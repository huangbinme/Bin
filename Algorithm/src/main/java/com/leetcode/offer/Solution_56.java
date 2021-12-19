package com.leetcode.offer;

public class Solution_56 {
    public int[] singleNumbers(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        n = n & -n;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & n) == 0){
                ans[0] ^= nums[i];
            }else {
                ans[1] ^= nums[i];
            }
        }
        return ans;
    }
}
