package com.review;

public class Solution_31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        for (int i = nums.length - 2; i >= 0; i--) {
            int j = nextPermutation(nums, i, i + 1, nums.length);
            if (j != -1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                break;
            }
        }
    }

    private int nextPermutation(int[] nums, int start, int l, int r) {
        if (nums[start] >= nums[r - 1]) {
            int last = nums[start];
            for (int i = start; i < r - 1; i++) {
                nums[i] = nums[i + 1];
            }
            nums[r - 1] = last;
            return -1;
        } else {
            for (int i = l; i < r; i++) {
                if (nums[i] > nums[start]) return i;
            }
        }
        return 0;
    }
}
