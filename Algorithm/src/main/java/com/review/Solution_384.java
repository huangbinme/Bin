package com.review;

import java.util.Arrays;
import java.util.Random;

public class Solution_384 {

    int[] nums;

    int[] randomNums;

    Random random = new Random();

    public Solution_384(int[] nums) {
        this.nums = nums;
        this.randomNums = Arrays.copyOf(nums, nums.length);
    }

    public int[] reset() {
        randomNums = Arrays.copyOf(nums, nums.length);
        return randomNums;
    }

    public int[] shuffle() {
        for (int i = 0; i < randomNums.length; i++) {
            int j = i + random.nextInt(randomNums.length - i);
            int t = randomNums[i];
            randomNums[i] = randomNums[j];
            randomNums[j] = t;
        }
        return randomNums;
    }
}
