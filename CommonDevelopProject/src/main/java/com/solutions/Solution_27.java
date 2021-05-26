package com.solutions;

public class Solution_27 {
    public int removeElement(int[] nums, int val) {
        int nLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) exchange(nums, nLength, i);
        }
        return nLength;
    }

    private void exchange(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
