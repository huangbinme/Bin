package com.solutions;

public class Solution_283 {
    public void moveZeroes(int[] nums) {
        int targetIndex = nums.length - 1;
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[point] == 0) {
                push(nums, point, targetIndex--);
            } else {
                point++;
            }
        }
    }

    private void push(int[] ints, int zeroIndex, int targetIndex) {
        for (int i = zeroIndex; i < targetIndex; i++) {
            exchange(ints, i, i + 1);
        }
    }

    private void exchange(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
