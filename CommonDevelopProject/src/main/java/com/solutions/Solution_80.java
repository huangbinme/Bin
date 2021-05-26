package com.solutions;

public class Solution_80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int nLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (changeCondition(nums, nLength, i)) {
                exchange(nums, i, nLength++);
            }
        }
        return nLength;
    }

    private boolean changeCondition(int[] nums, int nLength, int j) {
        return (nLength - 2 < 0) || nums[nLength - 2] != nums[j];
    }

    private void exchange(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
