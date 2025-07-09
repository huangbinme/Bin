package com.review;

public class Solution_198 {
    public int rob(int[] nums) {
        int x = nums[0], y = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmpX = x, tmpY = y;
            x = tmpY + nums[i];
            y = Math.max(tmpX, tmpY);
        }
        return Math.max(x, y);
    }
}
