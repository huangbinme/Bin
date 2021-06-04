package com.leetcode;

import com.algorithm.sort.SortingUtil;

public class Solution_912 {
    public int[] sortArray(int[] nums) {
        int h = nums.length / 2;
        while (h >= 1) {
            for (int i = 0; i < h; i++) {
                for (int j = i + h; j < nums.length; j = j + h) {
                    for (int k = j - h; k >= 0; k = k - h) {
                        if (nums[k] > nums[k + h]) {
                            exchange(nums, k, k + h);
                        } else {
                            break;
                        }
                    }
                }
            }
            h = h / 2;
        }
        return nums;
    }

    public void exchange(int[] input, int var1, int var2) {
        int tmp = input[var1];
        input[var1] = input[var2];
        input[var2] = tmp;
    }
}
