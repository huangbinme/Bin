package com.leetcode;

import java.util.Arrays;
import java.util.Random;

public class Solution_384 {

    private Random random = new Random();

    private int[] nums;

    public Solution_384(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int[] newNums = Arrays.copyOf(this.nums, nums.length);
        for (int i = newNums.length - 1; i > 0; i--) {
            swap(newNums, i, random.nextInt(i + 1));
        }
        return newNums;
    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }
}
