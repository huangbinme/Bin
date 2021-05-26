package com.solutions;

public class Solution_5719 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int bitNum = 0;
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            bitNum = bitNum ^ nums[nums.length - 1 - i];
            result[i] = getMaxNum(bitNum, maximumBit);
        }
        return result;
    }

    private int getMaxNum(int i, int maximumBit) {
        return i ^ (1 << maximumBit) - 1;
    }
}
