package com.algorithm.sort;

public class BubbleSort implements BaseSort {
    @Override
    public int[] sort(int[] input) {
        for (int i = input.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (input[j] > input[j + 1]) {
                    swap(input, j, j + 1);
                }
            }
        }
        return input;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
