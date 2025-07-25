package com.review;

public class Solution_75 {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > r) break;
            while (l <= i && i <= r && nums[i] != 1) {
                if (nums[i] == 0) {
                    swap(nums, i, l);
                    l++;
                } else if (nums[i] == 2) {
                    swap(nums, i, r);
                    r--;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
