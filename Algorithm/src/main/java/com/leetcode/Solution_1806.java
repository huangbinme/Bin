package com.leetcode;

import java.util.Arrays;

public class Solution_1806 {
    public int reinitializePermutation(int n) {
        int ans = 0;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        while (true) {
            nums = move(nums);
            ans++;
            if (validate(nums)) break;
        }
        return ans;
    }

    private boolean validate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return false;
        }
        return true;
    }

    private int[] move(int[] old) {
        int[] newNums = Arrays.copyOf(old, old.length);
        for (int i = 0; i < old.length; i++) {
            if (i % 2 == 0) {
                newNums[i] = old[i / 2];
            } else {
                newNums[i] = old[old.length / 2 + (i - 1) / 2];
            }
        }
        return newNums;
    }
}
