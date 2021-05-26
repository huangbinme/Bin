package com.solutions;

public class Solution_Offer_03 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) continue;
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) return nums[i];
                exchange(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
