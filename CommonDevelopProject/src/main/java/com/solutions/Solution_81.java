package com.solutions;

public class Solution_81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return true;
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
