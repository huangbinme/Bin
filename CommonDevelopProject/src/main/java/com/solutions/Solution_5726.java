package com.solutions;

public class Solution_5726 {
    public int arraySign(int[] nums) {
        boolean negativeNum = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return 0;
            if (nums[i] < 0) negativeNum = !negativeNum;
        }
        return negativeNum ? -1 : 1;
    }
}
