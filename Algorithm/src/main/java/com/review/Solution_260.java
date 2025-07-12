package com.review;

public class Solution_260 {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }
        int xLowBit = Integer.lowestOneBit(x);
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((xLowBit & nums[i]) == 0) {
                ans1 ^= nums[i];
            } else {
                ans2 ^= nums[i];
            }
        }
        return new int[]{ans1, ans2};
    }
}
